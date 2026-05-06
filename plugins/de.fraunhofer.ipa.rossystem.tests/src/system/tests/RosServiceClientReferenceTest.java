/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosServiceClientReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Service Client Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosServiceClientReferenceTest extends InterfaceReferenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RosServiceClientReferenceTest.class);
	}

	/**
	 * Constructs a new Ros Service Client Reference test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RosServiceClientReferenceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ros Service Client Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RosServiceClientReference getFixture() {
		return (RosServiceClientReference)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RossystemFactory.eINSTANCE.createRosServiceClientReference());
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

} //RosServiceClientReferenceTest
