/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosActionConnection;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Action Connection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosActionConnectionTest extends RosConnectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RosActionConnectionTest.class);
	}

	/**
	 * Constructs a new Ros Action Connection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RosActionConnectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ros Action Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RosActionConnection getFixture() {
		return (RosActionConnection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createRosActionConnection());
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

} //RosActionConnectionTest
