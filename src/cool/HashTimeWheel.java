package cool;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HashTimeWheel 
{
	private int maxTimers = 60;
	private long interval = 1000;

	private ConcurrentLinkedQueue<TimerTask>[] timerSlots;

	private volatile int currentSlot = 0;

	private volatile boolean start;

	public HashTimeWheel() {
	}

	public int getMaxTimers() {
		return maxTimers;
	}

	public void setMaxTimers(int maxTimers) {
		ValidParams.IsLess(maxTimers, "setMaxTimers(eror)", true);
		this.maxTimers = maxTimers;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		ValidParams.IsLess(interval, "setInterval(eror)", true);
		this.interval = interval;
	}

	public void add(long delay, Runnable run) {
		ValidParams.IsLess(delay, "add(eror)", true);
		ValidParams.IsNull(run, "add(eror)", true);

		final int curSlot = currentSlot;
		final int ticks = delay > interval ? (int) (delay / interval) : 1;
		final int index = (curSlot + (ticks % maxTimers)) % maxTimers;
		final int round = (ticks - 1) / maxTimers;

		timerSlots[index].add(new TimerTask(round, run));
	}

	public boolean status() {
		return start;
	}

	@SuppressWarnings("unchecked")
	public void start() {
		if (! start) {
			synchronized (this) {
				if (! start)
				{
					timerSlots = new ConcurrentLinkedQueue[maxTimers];

					for (int i = 0; i < timerSlots.length; i++) {
						timerSlots[i] = new ConcurrentLinkedQueue<TimerTask>();
					}

					start = true;
					new Thread(new Worker(), "firefly time wheel").start();
				}
			}
		}
	}

	public void stop() {
		start = false;
		timerSlots = null;
	}

	private final class Worker implements Runnable {
		@Override
		public void run() {
			while (start) {
				int currentSlotTemp = currentSlot;

				ConcurrentLinkedQueue<TimerTask> timerSlot = timerSlots[currentSlotTemp++];
				currentSlotTemp %= timerSlots.length;

				for (Iterator<TimerTask> iterator = timerSlot.iterator(); iterator.hasNext();) {
					if (iterator.next().runTask())
						iterator.remove();
				}

				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				currentSlot = currentSlotTemp;
			}
		}
	}

	private final class TimerTask {
		private int round;
		private Runnable run;

		public TimerTask(int round, Runnable run) {
			this.round = round;
			this.run = run;
		}

		public boolean runTask() {
			if (round == 0) {
				run.run();
				return true;
			} else {
				round--;
			}

			return false;
		}
	}
}
