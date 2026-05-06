/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosTopicConnection;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Topic Connection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosTopicConnectionTest extends RosConnectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RosTopicConnectionTest.class);
	}

	/**
	 * Constructs a new Ros Topic Connection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RosTopicConnectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ros Topic Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RosTopicConnection getFixture() {
		return (RosTopicConnection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createRosTopicConnection());
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

} //RosTopicConnectionTest
