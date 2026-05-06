/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.Rossystem;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rossystem</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RossystemTest extends SystemTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RossystemTest.class);
	}

	/**
	 * Constructs a new Rossystem test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RossystemTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Rossystem test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Rossystem getFixture() {
		return (Rossystem)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createRossystem());
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

} //RossystemTest
