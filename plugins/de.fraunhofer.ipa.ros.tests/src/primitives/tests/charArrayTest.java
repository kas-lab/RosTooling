/**
 */
package primitives.tests;

import junit.textui.TestRunner;

import primitives.PrimitivesFactory;
import primitives.charArray;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>char Array</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class charArrayTest extends AbstractTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(charArrayTest.class);
	}

	/**
	 * Constructs a new char Array test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public charArrayTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this char Array test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected charArray getFixture() {
		return (charArray)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PrimitivesFactory.eINSTANCE.createcharArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //charArrayTest
