/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosServiceConnection;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Service Connection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosServiceConnectionTest extends RosConnectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RosServiceConnectionTest.class);
	}

	/**
	 * Constructs a new Ros Service Connection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RosServiceConnectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ros Service Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RosServiceConnection getFixture() {
		return (RosServiceConnection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createRosServiceConnection());
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

} //RosServiceConnectionTest
