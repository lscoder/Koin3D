/**
 * 
 */
package jscenegraph.port;

import jscenegraph.database.inventor.SbVec3f;
import jscenegraph.database.inventor.SbVec3fSingle;

/**
 * @author Yves Boyadjian
 *
 */
public class SbVec3fArray {
	
	private float[] valuesArray;

	private int delta;
	
	public SbVec3fArray(SbVec3fArray other, int delta) {
		valuesArray = other.valuesArray;
		this.delta = other.delta + delta;
	}

	public SbVec3fArray(float[] valuesArray) {
		this.valuesArray = valuesArray;
	}

	public SbVec3fArray(SbVec3fSingle singleSbVec3f) {
		valuesArray = singleSbVec3f.getValue();
	}

	public SbVec3f get(int index) {
		return new SbVec3f(valuesArray, (index+delta)*3);
	}

	public SbVec3fArray plus(int delta) {
		return new SbVec3fArray(this,delta);
	}

	public static SbVec3fArray allocate(int maxPoints) {
		return new SbVec3fArray(new float[maxPoints*3]);
	}
	
	public FloatArray toFloatArray() {
		return new FloatArray(delta*3,valuesArray);
	}
}
