package cool;

/**
 * Valid-Params<p>
 *
 * (def valid-params?
 *   (x y)
 *     (and (type x) (type y)))
 *
 * (de function
 *   (x y)
 *     (cond ((not (valid-params? x y)) "Comments!!!")
 *     ((or (< x 0) (< y 0)) (function (x) (y)))
 *     ((< x y) (function y x))
 *     ((= y 0) x)
 *     ((! y))
 *     (t (function y (x y)))))
 *  (throws)
 */
public class ValidParams 
{
    public static void IsTrue(boolean expression, String message, boolean _throws) {
        if (! expression) {
        	if (_throws)
        		throw new IllegalArgumentException(message);
        }
    }

    public static <T> void IsNull(T expression, String message, boolean _throws) {
    	if (expression == null) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static <T> boolean IsNull(T expression) {
    	return expression != null;
    }

	public static void IsEmpty(boolean expression, String message) {
		if (! expression)
			throw new IllegalArgumentException(message);
	}

    public static void IsEmpty(String expression, String message, boolean _throws) {
    	if (expression == "" || expression == null || "".equals(expression)) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static boolean IsEmpty(String expression) {
    	return ! expression.equals("");
    }

    public static <T> void IsEmpty(T expression, String message, boolean _throws) {
    	if (expression == null) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static <T> void IsEqual(T expression_1, T expression_2, String message, boolean _throws) {
    	if (expression_1 != expression_2) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static <T extends Comparable<? super T> > void IsLess(T expression, String message, boolean _throws) {
    	if ((Integer)expression < 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static <T> void IsLessEqual(T expression, String message, boolean _throws) {
    	if ((Integer)expression <= 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static void IsLess(int expression, String message, boolean _throws) {
    	if (expression < 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static void IsLessEqual(int expression, String message, boolean _throws) {
    	if (expression <= 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static void IsLess(long expression, String message, boolean _throws) {
    	if (expression < 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }

    public static void IsLessEqual(long expression, String message, boolean _throws) {
    	if (expression <= 0) {
    		if (_throws)
        		throw new IllegalArgumentException(message);

    	}
    }

    public static <T> void IsGreater(T expression, T greater, String message, boolean _throws) {
    	if ((Integer)expression > (Integer)greater) {
    		if (_throws)
        		throw new IllegalArgumentException(message);
    	}
    }
}
