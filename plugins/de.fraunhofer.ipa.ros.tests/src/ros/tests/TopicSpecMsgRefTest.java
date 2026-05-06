/**
 */
package ros.tests;

import junit.textui.TestRunner;

import primitives.tests.AbstractTypeTest;

import ros.RosFactory;
import ros.TopicSpecMsgRef;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Topic Spec Msg Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopicSpecMsgRefTest extends AbstractTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TopicSpecMsgRefTest.class);
	}

	/**
	 * Constructs a new Topic Spec Msg Ref test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicSpecMsgRefTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Topic Spec Msg Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TopicSpecMsgRef getFixture() {
		return (TopicSpecMsgRef)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RosFactory.eINSTANCE.createTopicSpecMsgRef());
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

} //TopicSpecMsgRefTest
