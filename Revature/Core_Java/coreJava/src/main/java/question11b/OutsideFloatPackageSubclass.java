package question11b;

import question11a.ProtectedFloatClass;

/** 
 * @author Brandon Semba
 *
 * This class is used to demonstrate protected-level access. It
 * is outside of the package where ProtectedFloatClass is located, but by extending
 * its class, this class is able to gain access to it's parent's protected float variables
 */
public class OutsideFloatPackageSubclass extends ProtectedFloatClass {
	
	// Gets one of the protected float members from inherited class
	// outside of package
	public float getProtecedFloat1() {
		return super.f1;
	}
	
	// Gets the other protected float member from inerhited class outside of
	// package
	public float getProtecedFloat2() {
		return super.f2;
	}
}
