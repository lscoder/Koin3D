/**
 * 
 */
package jscenegraph.port;

import jscenegraph.database.inventor.SbVec3f;
import jscenegraph.database.inventor.SbVec3fSingle;
import jscenegraph.database.inventor.SbVec4f;
import jscenegraph.database.inventor.SbVec4fSingle;

/**
 * @author Yves Boyadjian
 *
 */
public class SbVec4fArray {

	private float[] valuesArray;

	private int delta;
	
	public SbVec4fArray(SbVec4fArray other, int delta) {
		valuesArray = other.valuesArray;
		this.delta = other.delta + delta;
	}

	public SbVec4fArray(float[] valuesArray) {
		this.valuesArray = valuesArray;
	}

	public SbVec4fArray(SbVec4fSingle singleSbVec4f) {
		valuesArray = singleSbVec4f.getValue();
	}

	public SbVec4f get(int index) {
		return new SbVec4f(valuesArray, (index+delta)*4);
	}

	public SbVec4fArray plus(int delta) {
		return new SbVec4fArray(this,delta);
	}

	public static SbVec4fArray allocate(int maxPoints) {
		return new SbVec4fArray(new float[maxPoints*4]);
	}
	
	public FloatArray toFloatArray() {
		return new FloatArray(delta*4,valuesArray);
	}
	
	public float[] toFloat() {
		
		if(delta != 0) {
			throw new IllegalStateException();
		}
		
		return valuesArray;
	}
}
