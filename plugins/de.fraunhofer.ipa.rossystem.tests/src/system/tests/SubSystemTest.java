/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RossystemFactory;
import system.SubSystem;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubSystemTest extends ComponentTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SubSystemTest.class);
	}

	/**
	 * Constructs a new Sub System test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystemTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sub System test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SubSystem getFixture() {
		return (SubSystem)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createSubSystem());
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

} //SubSystemTest
