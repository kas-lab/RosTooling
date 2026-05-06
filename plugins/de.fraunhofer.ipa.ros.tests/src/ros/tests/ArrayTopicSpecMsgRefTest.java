/**
 */
package ros.tests;

import junit.textui.TestRunner;

import primitives.tests.AbstractTypeTest;

import ros.ArrayTopicSpecMsgRef;
import ros.RosFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Array Topic Spec Msg Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArrayTopicSpecMsgRefTest extends AbstractTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArrayTopicSpecMsgRefTest.class);
	}

	/**
	 * Constructs a new Array Topic Spec Msg Ref test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayTopicSpecMsgRefTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Array Topic Spec Msg Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ArrayTopicSpecMsgRef getFixture() {
		return (ArrayTopicSpecMsgRef)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RosFactory.eINSTANCE.createArrayTopicSpecMsgRef());
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

} //ArrayTopicSpecMsgRefTest
