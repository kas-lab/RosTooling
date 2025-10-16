package de.fraunhofer.ipa.ros2.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fraunhofer.ipa.ros2.services.Ros2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRos2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Lease_duration", "Serviceclients", "Serviceservers", "Transient_local", "Actionclients", "Actionservers", "Dependencies", "Parameter_qos", "ParameterAny", "FromGitRepo", "Reliability", "Services_qos", "Subscribers", "Best_effort", "Default_qos", "Durability", "Liveliness", "Parameters", "Publishers", "Artifacts", "Sensor_qos", "GraphName", "Automatic", "Deadline", "Float32_1", "Float64_1", "Keep_last", "Lifespan", "Actions", "Default", "Duration", "Feedback", "History", "Infinite", "Keep_all", "Profile", "Reliable", "Response", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Volatile", "Boolean", "Integer", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Message", "Request", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Depth", "Int8_1", "Manual", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Int16", "Int32", "Int64", "Msgs", "Node_1", "Srvs", "Type_1", "Uint8", "Value", "Date", "List", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Qos", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "Colon", "LeftSquareBracket", "RightSquareBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=32;
    public static final int Node=98;
    public static final int RULE_DATE_TIME=119;
    public static final int Uint64_1=49;
    public static final int Manual=73;
    public static final int Serviceclients=9;
    public static final int String=65;
    public static final int History=40;
    public static final int Int16=81;
    public static final int Float32=53;
    public static final int Goal=95;
    public static final int Actionservers=13;
    public static final int Bool=92;
    public static final int Msgs=84;
    public static final int Infinite=41;
    public static final int Uint16=76;
    public static final int Boolean=51;
    public static final int ExternalDependency=4;
    public static final int Uint8=88;
    public static final int Parameters=25;
    public static final int RULE_ID=120;
    public static final int Actions=36;
    public static final int RULE_DIGIT=109;
    public static final int GlobalNamespace=7;
    public static final int Artifacts=27;
    public static final int Node_1=85;
    public static final int Int16_1=55;
    public static final int Header=64;
    public static final int RULE_INT=122;
    public static final int Byte=93;
    public static final int RULE_ML_COMMENT=129;
    public static final int LeftSquareBracket=107;
    public static final int Automatic=30;
    public static final int Base64=62;
    public static final int Profile=43;
    public static final int Depth=71;
    public static final int Comma=105;
    public static final int RULE_MESSAGE_ASIGMENT=123;
    public static final int LeftSquareBracketRightSquareBracket=104;
    public static final int Int32=82;
    public static final int Char=94;
    public static final int Publishers=26;
    public static final int Parameter_qos=15;
    public static final int Srvs=86;
    public static final int RULE_DECINT=112;
    public static final int Reliable=44;
    public static final int Uint32=77;
    public static final int FromGitRepo=17;
    public static final int RULE_HOUR=117;
    public static final int Int8=96;
    public static final int Default=37;
    public static final int Int8_1=72;
    public static final int Uint16_1=47;
    public static final int Type=101;
    public static final int Float64=54;
    public static final int Int32_1=56;
    public static final int Keep_all=42;
    public static final int RULE_BINARY=110;
    public static final int String_1=75;
    public static final int Subscribers=20;
    public static final int String_2=46;
    public static final int Lifespan=35;
    public static final int Actionclients=12;
    public static final int RULE_DAY=114;
    public static final int RULE_BEGIN=124;
    public static final int Services_qos=19;
    public static final int RULE_BOOLEAN=111;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=10;
    public static final int RULE_YEAR=116;
    public static final int Result=74;
    public static final int Name=97;
    public static final int RULE_MIN_SEC=118;
    public static final int Default_qos=22;
    public static final int Char_1=70;
    public static final int ParameterAny=16;
    public static final int List=91;
    public static final int Dependencies=14;
    public static final int RightSquareBracket=108;
    public static final int PrivateNamespace=6;
    public static final int GraphName=29;
    public static final int Liveliness=24;
    public static final int Byte_1=69;
    public static final int Deadline=31;
    public static final int Float64_1=33;
    public static final int Durability=23;
    public static final int Duration=38;
    public static final int Uint32_1=48;
    public static final int Double=63;
    public static final int Keep_last=34;
    public static final int Type_1=87;
    public static final int Value=89;
    public static final int Transient_local=11;
    public static final int Uint64=78;
    public static final int Lease_duration=8;
    public static final int Action=67;
    public static final int RULE_END=125;
    public static final int Message=58;
    public static final int Value_1=79;
    public static final int Time=100;
    public static final int RULE_STRING=121;
    public static final int Best_effort=21;
    public static final int Bool_1=68;
    public static final int Any=102;
    public static final int Struct=66;
    public static final int RULE_SL_COMMENT=126;
    public static final int Uint8_1=61;
    public static final int RULE_DOUBLE=113;
    public static final int Feedback=39;
    public static final int RULE_ROS_CONVENTION_A=127;
    public static final int RULE_ROS_CONVENTION_PARAM=128;
    public static final int Colon=106;
    public static final int EOF=-1;
    public static final int Ns=103;
    public static final int RULE_WS=130;
    public static final int Int64_1=57;
    public static final int Request=59;
    public static final int Service=60;
    public static final int Sensor_qos=28;
    public static final int RULE_ANY_OTHER=131;
    public static final int Volatile=50;
    public static final int Date=90;
    public static final int Response=45;
    public static final int Integer=52;
    public static final int Array=80;
    public static final int Qos=99;
    public static final int Int64=83;
    public static final int RULE_MONTH=115;
    public static final int Reliability=18;

    // delegates
    // delegators


        public InternalRos2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRos2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRos2Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalRos2Parser.g"; }



     	private Ros2GrammarAccess grammarAccess;

        public InternalRos2Parser(TokenStream input, Ros2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Package";
       	}

       	@Override
       	protected Ros2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePackage"
    // InternalRos2Parser.g:57:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // InternalRos2Parser.g:57:48: (iv_rulePackage= rulePackage EOF )
            // InternalRos2Parser.g:58:2: iv_rulePackage= rulePackage EOF
            {
             newCompositeNode(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackage=rulePackage();

            state._fsp--;

             current =iv_rulePackage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // InternalRos2Parser.g:64:1: rulePackage returns [EObject current=null] : this_AmentPackage_0= ruleAmentPackage ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        EObject this_AmentPackage_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:70:2: (this_AmentPackage_0= ruleAmentPackage )
            // InternalRos2Parser.g:71:2: this_AmentPackage_0= ruleAmentPackage
            {

            		newCompositeNode(grammarAccess.getPackageAccess().getAmentPackageParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_AmentPackage_0=ruleAmentPackage();

            state._fsp--;


            		current = this_AmentPackage_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleAmentPackage"
    // InternalRos2Parser.g:82:1: entryRuleAmentPackage returns [EObject current=null] : iv_ruleAmentPackage= ruleAmentPackage EOF ;
    public final EObject entryRuleAmentPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAmentPackage = null;


        try {
            // InternalRos2Parser.g:82:53: (iv_ruleAmentPackage= ruleAmentPackage EOF )
            // InternalRos2Parser.g:83:2: iv_ruleAmentPackage= ruleAmentPackage EOF
            {
             newCompositeNode(grammarAccess.getAmentPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAmentPackage=ruleAmentPackage();

            state._fsp--;

             current =iv_ruleAmentPackage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAmentPackage"


    // $ANTLR start "ruleAmentPackage"
    // InternalRos2Parser.g:89:1: ruleAmentPackage returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) ;
    public final EObject ruleAmentPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token this_END_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_5_0 = null;

        EObject lv_artifact_8_0 = null;

        EObject lv_dependency_12_0 = null;

        EObject lv_dependency_14_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:95:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) )
            // InternalRos2Parser.g:96:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            {
            // InternalRos2Parser.g:96:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            // InternalRos2Parser.g:97:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END
            {
            // InternalRos2Parser.g:97:3: ()
            // InternalRos2Parser.g:98:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAmentPackageAccess().getAmentPackageAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:104:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos2Parser.g:105:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos2Parser.g:105:4: (lv_name_1_0= ruleRosNames )
            // InternalRos2Parser.g:106:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getAmentPackageAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAmentPackageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getAmentPackageAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_5); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getAmentPackageAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos2Parser.g:131:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==FromGitRepo) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalRos2Parser.g:132:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getAmentPackageAccess().getFromGitRepoKeyword_4_0());
                    			
                    // InternalRos2Parser.g:136:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRos2Parser.g:137:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRos2Parser.g:137:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRos2Parser.g:138:6: lv_fromGitRepo_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAmentPackageAccess().getFromGitRepoEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_fromGitRepo_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAmentPackageRule());
                    						}
                    						set(
                    							current,
                    							"fromGitRepo",
                    							lv_fromGitRepo_5_0,
                    							"de.fraunhofer.ipa.ros.Basics.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:156:3: (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Artifacts) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalRos2Parser.g:157:4: otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END
                    {
                    otherlv_6=(Token)match(input,Artifacts,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getAmentPackageAccess().getArtifactsKeyword_5_0());
                    			
                    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

                    				newLeafNode(this_BEGIN_7, grammarAccess.getAmentPackageAccess().getBEGINTerminalRuleCall_5_1());
                    			
                    // InternalRos2Parser.g:165:4: ( (lv_artifact_8_0= ruleArtifact ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==Node||LA2_0==RULE_ID||LA2_0==RULE_ROS_CONVENTION_A) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalRos2Parser.g:166:5: (lv_artifact_8_0= ruleArtifact )
                    	    {
                    	    // InternalRos2Parser.g:166:5: (lv_artifact_8_0= ruleArtifact )
                    	    // InternalRos2Parser.g:167:6: lv_artifact_8_0= ruleArtifact
                    	    {

                    	    						newCompositeNode(grammarAccess.getAmentPackageAccess().getArtifactArtifactParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_8);
                    	    lv_artifact_8_0=ruleArtifact();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getAmentPackageRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"artifact",
                    	    							lv_artifact_8_0,
                    	    							"de.fraunhofer.ipa.ros.Ros.Artifact");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    this_END_9=(Token)match(input,RULE_END,FOLLOW_9); 

                    				newLeafNode(this_END_9, grammarAccess.getAmentPackageAccess().getENDTerminalRuleCall_5_3());
                    			

                    }
                    break;

            }

            // InternalRos2Parser.g:189:3: (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Dependencies) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRos2Parser.g:190:4: otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket
                    {
                    otherlv_10=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getAmentPackageAccess().getDependenciesKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getAmentPackageAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalRos2Parser.g:198:4: ( (lv_dependency_12_0= ruleDependency ) )
                    // InternalRos2Parser.g:199:5: (lv_dependency_12_0= ruleDependency )
                    {
                    // InternalRos2Parser.g:199:5: (lv_dependency_12_0= ruleDependency )
                    // InternalRos2Parser.g:200:6: lv_dependency_12_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getAmentPackageAccess().getDependencyDependencyParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_dependency_12_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAmentPackageRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_12_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos2Parser.g:217:4: (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==Comma) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalRos2Parser.g:218:5: otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getAmentPackageAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalRos2Parser.g:222:5: ( (lv_dependency_14_0= ruleDependency ) )
                    	    // InternalRos2Parser.g:223:6: (lv_dependency_14_0= ruleDependency )
                    	    {
                    	    // InternalRos2Parser.g:223:6: (lv_dependency_14_0= ruleDependency )
                    	    // InternalRos2Parser.g:224:7: lv_dependency_14_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getAmentPackageAccess().getDependencyDependencyParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_dependency_14_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAmentPackageRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_14_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Dependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,RightSquareBracket,FOLLOW_13); 

                    				newLeafNode(otherlv_15, grammarAccess.getAmentPackageAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            this_END_16=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_16, grammarAccess.getAmentPackageAccess().getENDTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAmentPackage"


    // $ANTLR start "entryRuleQualityOfService"
    // InternalRos2Parser.g:255:1: entryRuleQualityOfService returns [EObject current=null] : iv_ruleQualityOfService= ruleQualityOfService EOF ;
    public final EObject entryRuleQualityOfService() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityOfService = null;


        try {
            // InternalRos2Parser.g:255:57: (iv_ruleQualityOfService= ruleQualityOfService EOF )
            // InternalRos2Parser.g:256:2: iv_ruleQualityOfService= ruleQualityOfService EOF
            {
             newCompositeNode(grammarAccess.getQualityOfServiceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualityOfService=ruleQualityOfService();

            state._fsp--;

             current =iv_ruleQualityOfService; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualityOfService"


    // $ANTLR start "ruleQualityOfService"
    // InternalRos2Parser.g:262:1: ruleQualityOfService returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) ) this_END_21= RULE_END ) ;
    public final EObject ruleQualityOfService() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token otherlv_3=null;
        Token lv_QoSProfile_4_1=null;
        Token lv_QoSProfile_4_2=null;
        Token lv_QoSProfile_4_3=null;
        Token lv_QoSProfile_4_4=null;
        Token otherlv_5=null;
        Token lv_History_6_1=null;
        Token lv_History_6_2=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_Reliability_10_1=null;
        Token lv_Reliability_10_2=null;
        Token otherlv_11=null;
        Token lv_Durability_12_1=null;
        Token lv_Durability_12_2=null;
        Token otherlv_13=null;
        Token lv_LeaseDuration_14_2=null;
        Token otherlv_15=null;
        Token lv_Liveliness_16_1=null;
        Token lv_Liveliness_16_2=null;
        Token otherlv_17=null;
        Token lv_Lifespan_18_2=null;
        Token otherlv_19=null;
        Token lv_Deadline_20_2=null;
        Token this_END_21=null;
        AntlrDatatypeRuleToken lv_Depth_8_0 = null;

        AntlrDatatypeRuleToken lv_LeaseDuration_14_1 = null;

        AntlrDatatypeRuleToken lv_Lifespan_18_1 = null;

        AntlrDatatypeRuleToken lv_Deadline_20_1 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:268:2: ( ( () this_BEGIN_1= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) ) this_END_21= RULE_END ) )
            // InternalRos2Parser.g:269:2: ( () this_BEGIN_1= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) ) this_END_21= RULE_END )
            {
            // InternalRos2Parser.g:269:2: ( () this_BEGIN_1= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) ) this_END_21= RULE_END )
            // InternalRos2Parser.g:270:3: () this_BEGIN_1= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) ) this_END_21= RULE_END
            {
            // InternalRos2Parser.g:270:3: ()
            // InternalRos2Parser.g:271:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getQualityOfServiceAccess().getQualityOfServiceAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getQualityOfServiceAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRos2Parser.g:281:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) ) )
            // InternalRos2Parser.g:282:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) )
            {
            // InternalRos2Parser.g:282:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* ) )
            // InternalRos2Parser.g:283:5: ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            				
            // InternalRos2Parser.g:286:5: ( ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )* )
            // InternalRos2Parser.g:287:6: ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )*
            {
            // InternalRos2Parser.g:287:6: ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )*
            loop14:
            do {
                int alt14=10;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalRos2Parser.g:288:4: ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:288:4: ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:289:5: {...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalRos2Parser.g:289:113: ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) )
            	    // InternalRos2Parser.g:290:6: ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalRos2Parser.g:293:9: ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) )
            	    // InternalRos2Parser.g:293:10: {...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:293:19: (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) )
            	    // InternalRos2Parser.g:293:20: otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) )
            	    {
            	    otherlv_3=(Token)match(input,Profile,FOLLOW_15); 

            	    									newLeafNode(otherlv_3, grammarAccess.getQualityOfServiceAccess().getProfileKeyword_2_0_0());
            	    								
            	    // InternalRos2Parser.g:297:9: ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) )
            	    // InternalRos2Parser.g:298:10: ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) )
            	    {
            	    // InternalRos2Parser.g:298:10: ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) )
            	    // InternalRos2Parser.g:299:11: (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos )
            	    {
            	    // InternalRos2Parser.g:299:11: (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos )
            	    int alt6=4;
            	    switch ( input.LA(1) ) {
            	    case Default_qos:
            	        {
            	        alt6=1;
            	        }
            	        break;
            	    case Services_qos:
            	        {
            	        alt6=2;
            	        }
            	        break;
            	    case Sensor_qos:
            	        {
            	        alt6=3;
            	        }
            	        break;
            	    case Parameter_qos:
            	        {
            	        alt6=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt6) {
            	        case 1 :
            	            // InternalRos2Parser.g:300:12: lv_QoSProfile_4_1= Default_qos
            	            {
            	            lv_QoSProfile_4_1=(Token)match(input,Default_qos,FOLLOW_14); 

            	            												newLeafNode(lv_QoSProfile_4_1, grammarAccess.getQualityOfServiceAccess().getQoSProfileDefault_qosKeyword_2_0_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "QoSProfile", lv_QoSProfile_4_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:311:12: lv_QoSProfile_4_2= Services_qos
            	            {
            	            lv_QoSProfile_4_2=(Token)match(input,Services_qos,FOLLOW_14); 

            	            												newLeafNode(lv_QoSProfile_4_2, grammarAccess.getQualityOfServiceAccess().getQoSProfileServices_qosKeyword_2_0_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "QoSProfile", lv_QoSProfile_4_2, null);
            	            											

            	            }
            	            break;
            	        case 3 :
            	            // InternalRos2Parser.g:322:12: lv_QoSProfile_4_3= Sensor_qos
            	            {
            	            lv_QoSProfile_4_3=(Token)match(input,Sensor_qos,FOLLOW_14); 

            	            												newLeafNode(lv_QoSProfile_4_3, grammarAccess.getQualityOfServiceAccess().getQoSProfileSensor_qosKeyword_2_0_1_0_2());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "QoSProfile", lv_QoSProfile_4_3, null);
            	            											

            	            }
            	            break;
            	        case 4 :
            	            // InternalRos2Parser.g:333:12: lv_QoSProfile_4_4= Parameter_qos
            	            {
            	            lv_QoSProfile_4_4=(Token)match(input,Parameter_qos,FOLLOW_14); 

            	            												newLeafNode(lv_QoSProfile_4_4, grammarAccess.getQualityOfServiceAccess().getQoSProfileParameter_qosKeyword_2_0_1_0_3());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "QoSProfile", lv_QoSProfile_4_4, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos2Parser.g:352:4: ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:352:4: ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:353:5: {...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalRos2Parser.g:353:113: ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) )
            	    // InternalRos2Parser.g:354:6: ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalRos2Parser.g:357:9: ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) )
            	    // InternalRos2Parser.g:357:10: {...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:357:19: (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) )
            	    // InternalRos2Parser.g:357:20: otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) )
            	    {
            	    otherlv_5=(Token)match(input,History,FOLLOW_16); 

            	    									newLeafNode(otherlv_5, grammarAccess.getQualityOfServiceAccess().getHistoryKeyword_2_1_0());
            	    								
            	    // InternalRos2Parser.g:361:9: ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) )
            	    // InternalRos2Parser.g:362:10: ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) )
            	    {
            	    // InternalRos2Parser.g:362:10: ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) )
            	    // InternalRos2Parser.g:363:11: (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all )
            	    {
            	    // InternalRos2Parser.g:363:11: (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( LA7_0 == Keep_last ) {
            	        alt7=1;
            	    }
            	    else if ( LA7_0 == Keep_all ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalRos2Parser.g:364:12: lv_History_6_1= Keep_last
            	            {
            	            lv_History_6_1=(Token)match(input,Keep_last,FOLLOW_14); 

            	            												newLeafNode(lv_History_6_1, grammarAccess.getQualityOfServiceAccess().getHistoryKeep_lastKeyword_2_1_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "History", lv_History_6_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:375:12: lv_History_6_2= Keep_all
            	            {
            	            lv_History_6_2=(Token)match(input,Keep_all,FOLLOW_14); 

            	            												newLeafNode(lv_History_6_2, grammarAccess.getQualityOfServiceAccess().getHistoryKeep_allKeyword_2_1_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "History", lv_History_6_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos2Parser.g:394:4: ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:394:4: ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) )
            	    // InternalRos2Parser.g:395:5: {...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalRos2Parser.g:395:113: ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) )
            	    // InternalRos2Parser.g:396:6: ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalRos2Parser.g:399:9: ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) )
            	    // InternalRos2Parser.g:399:10: {...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:399:19: (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) )
            	    // InternalRos2Parser.g:399:20: otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) )
            	    {
            	    otherlv_7=(Token)match(input,Depth,FOLLOW_17); 

            	    									newLeafNode(otherlv_7, grammarAccess.getQualityOfServiceAccess().getDepthKeyword_2_2_0());
            	    								
            	    // InternalRos2Parser.g:403:9: ( (lv_Depth_8_0= ruleInteger0 ) )
            	    // InternalRos2Parser.g:404:10: (lv_Depth_8_0= ruleInteger0 )
            	    {
            	    // InternalRos2Parser.g:404:10: (lv_Depth_8_0= ruleInteger0 )
            	    // InternalRos2Parser.g:405:11: lv_Depth_8_0= ruleInteger0
            	    {

            	    											newCompositeNode(grammarAccess.getQualityOfServiceAccess().getDepthInteger0ParserRuleCall_2_2_1_0());
            	    										
            	    pushFollow(FOLLOW_14);
            	    lv_Depth_8_0=ruleInteger0();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getQualityOfServiceRule());
            	    											}
            	    											set(
            	    												current,
            	    												"Depth",
            	    												lv_Depth_8_0,
            	    												"de.fraunhofer.ipa.ros.Basics.Integer0");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos2Parser.g:428:4: ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:428:4: ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:429:5: {...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalRos2Parser.g:429:113: ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) )
            	    // InternalRos2Parser.g:430:6: ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalRos2Parser.g:433:9: ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) )
            	    // InternalRos2Parser.g:433:10: {...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:433:19: (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) )
            	    // InternalRos2Parser.g:433:20: otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) )
            	    {
            	    otherlv_9=(Token)match(input,Reliability,FOLLOW_18); 

            	    									newLeafNode(otherlv_9, grammarAccess.getQualityOfServiceAccess().getReliabilityKeyword_2_3_0());
            	    								
            	    // InternalRos2Parser.g:437:9: ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) )
            	    // InternalRos2Parser.g:438:10: ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) )
            	    {
            	    // InternalRos2Parser.g:438:10: ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) )
            	    // InternalRos2Parser.g:439:11: (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable )
            	    {
            	    // InternalRos2Parser.g:439:11: (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==Best_effort) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==Reliable) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalRos2Parser.g:440:12: lv_Reliability_10_1= Best_effort
            	            {
            	            lv_Reliability_10_1=(Token)match(input,Best_effort,FOLLOW_14); 

            	            												newLeafNode(lv_Reliability_10_1, grammarAccess.getQualityOfServiceAccess().getReliabilityBest_effortKeyword_2_3_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Reliability", lv_Reliability_10_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:451:12: lv_Reliability_10_2= Reliable
            	            {
            	            lv_Reliability_10_2=(Token)match(input,Reliable,FOLLOW_14); 

            	            												newLeafNode(lv_Reliability_10_2, grammarAccess.getQualityOfServiceAccess().getReliabilityReliableKeyword_2_3_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Reliability", lv_Reliability_10_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos2Parser.g:470:4: ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:470:4: ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:471:5: {...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // InternalRos2Parser.g:471:113: ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) )
            	    // InternalRos2Parser.g:472:6: ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 4);
            	    					
            	    // InternalRos2Parser.g:475:9: ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) )
            	    // InternalRos2Parser.g:475:10: {...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:475:19: (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) )
            	    // InternalRos2Parser.g:475:20: otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) )
            	    {
            	    otherlv_11=(Token)match(input,Durability,FOLLOW_19); 

            	    									newLeafNode(otherlv_11, grammarAccess.getQualityOfServiceAccess().getDurabilityKeyword_2_4_0());
            	    								
            	    // InternalRos2Parser.g:479:9: ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) )
            	    // InternalRos2Parser.g:480:10: ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) )
            	    {
            	    // InternalRos2Parser.g:480:10: ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) )
            	    // InternalRos2Parser.g:481:11: (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile )
            	    {
            	    // InternalRos2Parser.g:481:11: (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==Transient_local) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==Volatile) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // InternalRos2Parser.g:482:12: lv_Durability_12_1= Transient_local
            	            {
            	            lv_Durability_12_1=(Token)match(input,Transient_local,FOLLOW_14); 

            	            												newLeafNode(lv_Durability_12_1, grammarAccess.getQualityOfServiceAccess().getDurabilityTransient_localKeyword_2_4_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Durability", lv_Durability_12_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:493:12: lv_Durability_12_2= Volatile
            	            {
            	            lv_Durability_12_2=(Token)match(input,Volatile,FOLLOW_14); 

            	            												newLeafNode(lv_Durability_12_2, grammarAccess.getQualityOfServiceAccess().getDurabilityVolatileKeyword_2_4_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Durability", lv_Durability_12_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos2Parser.g:512:4: ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:512:4: ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:513:5: {...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 5)");
            	    }
            	    // InternalRos2Parser.g:513:113: ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) )
            	    // InternalRos2Parser.g:514:6: ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 5);
            	    					
            	    // InternalRos2Parser.g:517:9: ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) )
            	    // InternalRos2Parser.g:517:10: {...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:517:19: (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) )
            	    // InternalRos2Parser.g:517:20: otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) )
            	    {
            	    otherlv_13=(Token)match(input,Lease_duration,FOLLOW_20); 

            	    									newLeafNode(otherlv_13, grammarAccess.getQualityOfServiceAccess().getLease_durationKeyword_2_5_0());
            	    								
            	    // InternalRos2Parser.g:521:9: ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) )
            	    // InternalRos2Parser.g:522:10: ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) )
            	    {
            	    // InternalRos2Parser.g:522:10: ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) )
            	    // InternalRos2Parser.g:523:11: (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite )
            	    {
            	    // InternalRos2Parser.g:523:11: (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_STRING)) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==Infinite) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalRos2Parser.g:524:12: lv_LeaseDuration_14_1= ruleEString
            	            {

            	            												newCompositeNode(grammarAccess.getQualityOfServiceAccess().getLeaseDurationEStringParserRuleCall_2_5_1_0_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_LeaseDuration_14_1=ruleEString();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												set(
            	            													current,
            	            													"LeaseDuration",
            	            													lv_LeaseDuration_14_1,
            	            													"de.fraunhofer.ipa.ros.Basics.EString");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:540:12: lv_LeaseDuration_14_2= Infinite
            	            {
            	            lv_LeaseDuration_14_2=(Token)match(input,Infinite,FOLLOW_14); 

            	            												newLeafNode(lv_LeaseDuration_14_2, grammarAccess.getQualityOfServiceAccess().getLeaseDurationInfiniteKeyword_2_5_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "LeaseDuration", lv_LeaseDuration_14_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos2Parser.g:559:4: ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:559:4: ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:560:5: {...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 6)");
            	    }
            	    // InternalRos2Parser.g:560:113: ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) )
            	    // InternalRos2Parser.g:561:6: ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 6);
            	    					
            	    // InternalRos2Parser.g:564:9: ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) )
            	    // InternalRos2Parser.g:564:10: {...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:564:19: (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) )
            	    // InternalRos2Parser.g:564:20: otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) )
            	    {
            	    otherlv_15=(Token)match(input,Liveliness,FOLLOW_21); 

            	    									newLeafNode(otherlv_15, grammarAccess.getQualityOfServiceAccess().getLivelinessKeyword_2_6_0());
            	    								
            	    // InternalRos2Parser.g:568:9: ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) )
            	    // InternalRos2Parser.g:569:10: ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) )
            	    {
            	    // InternalRos2Parser.g:569:10: ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) )
            	    // InternalRos2Parser.g:570:11: (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual )
            	    {
            	    // InternalRos2Parser.g:570:11: (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==Automatic) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==Manual) ) {
            	        alt11=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalRos2Parser.g:571:12: lv_Liveliness_16_1= Automatic
            	            {
            	            lv_Liveliness_16_1=(Token)match(input,Automatic,FOLLOW_14); 

            	            												newLeafNode(lv_Liveliness_16_1, grammarAccess.getQualityOfServiceAccess().getLivelinessAutomaticKeyword_2_6_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Liveliness", lv_Liveliness_16_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:582:12: lv_Liveliness_16_2= Manual
            	            {
            	            lv_Liveliness_16_2=(Token)match(input,Manual,FOLLOW_14); 

            	            												newLeafNode(lv_Liveliness_16_2, grammarAccess.getQualityOfServiceAccess().getLivelinessManualKeyword_2_6_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Liveliness", lv_Liveliness_16_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRos2Parser.g:601:4: ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:601:4: ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:602:5: {...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 7)");
            	    }
            	    // InternalRos2Parser.g:602:113: ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) )
            	    // InternalRos2Parser.g:603:6: ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 7);
            	    					
            	    // InternalRos2Parser.g:606:9: ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) )
            	    // InternalRos2Parser.g:606:10: {...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:606:19: (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) )
            	    // InternalRos2Parser.g:606:20: otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) )
            	    {
            	    otherlv_17=(Token)match(input,Lifespan,FOLLOW_20); 

            	    									newLeafNode(otherlv_17, grammarAccess.getQualityOfServiceAccess().getLifespanKeyword_2_7_0());
            	    								
            	    // InternalRos2Parser.g:610:9: ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) )
            	    // InternalRos2Parser.g:611:10: ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) )
            	    {
            	    // InternalRos2Parser.g:611:10: ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) )
            	    // InternalRos2Parser.g:612:11: (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite )
            	    {
            	    // InternalRos2Parser.g:612:11: (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==Infinite) ) {
            	        alt12=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalRos2Parser.g:613:12: lv_Lifespan_18_1= ruleEString
            	            {

            	            												newCompositeNode(grammarAccess.getQualityOfServiceAccess().getLifespanEStringParserRuleCall_2_7_1_0_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_Lifespan_18_1=ruleEString();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												set(
            	            													current,
            	            													"Lifespan",
            	            													lv_Lifespan_18_1,
            	            													"de.fraunhofer.ipa.ros.Basics.EString");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:629:12: lv_Lifespan_18_2= Infinite
            	            {
            	            lv_Lifespan_18_2=(Token)match(input,Infinite,FOLLOW_14); 

            	            												newLeafNode(lv_Lifespan_18_2, grammarAccess.getQualityOfServiceAccess().getLifespanInfiniteKeyword_2_7_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Lifespan", lv_Lifespan_18_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRos2Parser.g:648:4: ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) )
            	    {
            	    // InternalRos2Parser.g:648:4: ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) )
            	    // InternalRos2Parser.g:649:5: {...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 8)");
            	    }
            	    // InternalRos2Parser.g:649:113: ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) )
            	    // InternalRos2Parser.g:650:6: ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 8);
            	    					
            	    // InternalRos2Parser.g:653:9: ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) )
            	    // InternalRos2Parser.g:653:10: {...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleQualityOfService", "true");
            	    }
            	    // InternalRos2Parser.g:653:19: (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) )
            	    // InternalRos2Parser.g:653:20: otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) )
            	    {
            	    otherlv_19=(Token)match(input,Deadline,FOLLOW_20); 

            	    									newLeafNode(otherlv_19, grammarAccess.getQualityOfServiceAccess().getDeadlineKeyword_2_8_0());
            	    								
            	    // InternalRos2Parser.g:657:9: ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) )
            	    // InternalRos2Parser.g:658:10: ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) )
            	    {
            	    // InternalRos2Parser.g:658:10: ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) )
            	    // InternalRos2Parser.g:659:11: (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite )
            	    {
            	    // InternalRos2Parser.g:659:11: (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==Infinite) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalRos2Parser.g:660:12: lv_Deadline_20_1= ruleEString
            	            {

            	            												newCompositeNode(grammarAccess.getQualityOfServiceAccess().getDeadlineEStringParserRuleCall_2_8_1_0_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_Deadline_20_1=ruleEString();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												set(
            	            													current,
            	            													"Deadline",
            	            													lv_Deadline_20_1,
            	            													"de.fraunhofer.ipa.ros.Basics.EString");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalRos2Parser.g:676:12: lv_Deadline_20_2= Infinite
            	            {
            	            lv_Deadline_20_2=(Token)match(input,Infinite,FOLLOW_14); 

            	            												newLeafNode(lv_Deadline_20_2, grammarAccess.getQualityOfServiceAccess().getDeadlineInfiniteKeyword_2_8_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getQualityOfServiceRule());
            	            												}
            	            												setWithLastConsumed(current, "Deadline", lv_Deadline_20_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2());
            				

            }

            this_END_21=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_21, grammarAccess.getQualityOfServiceAccess().getENDTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualityOfService"


    // $ANTLR start "entryRulePublisher"
    // InternalRos2Parser.g:710:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRos2Parser.g:710:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRos2Parser.g:711:2: iv_rulePublisher= rulePublisher EOF
            {
             newCompositeNode(grammarAccess.getPublisherRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePublisher=rulePublisher();

            state._fsp--;

             current =iv_rulePublisher; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePublisher"


    // $ANTLR start "rulePublisher"
    // InternalRos2Parser.g:717:1: rulePublisher returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:723:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:724:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:724:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:725:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:725:3: ()
            // InternalRos2Parser.g:726:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:732:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:733:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:733:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:734:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPublisherRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getPublisherAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:763:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:764:4: ( ruleEString )
            {
            // InternalRos2Parser.g:764:4: ( ruleEString )
            // InternalRos2Parser.g:765:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:779:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Ns) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRos2Parser.g:780:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getPublisherAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:784:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:785:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:785:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:786:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPublisherRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:804:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Qos) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRos2Parser.g:805:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getPublisherAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:809:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:810:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:810:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:811:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPublisherRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getPublisherAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePublisher"


    // $ANTLR start "entryRuleSubscriber"
    // InternalRos2Parser.g:837:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRos2Parser.g:837:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRos2Parser.g:838:2: iv_ruleSubscriber= ruleSubscriber EOF
            {
             newCompositeNode(grammarAccess.getSubscriberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubscriber=ruleSubscriber();

            state._fsp--;

             current =iv_ruleSubscriber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubscriber"


    // $ANTLR start "ruleSubscriber"
    // InternalRos2Parser.g:844:1: ruleSubscriber returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleSubscriber() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:850:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:851:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:851:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:852:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:852:3: ()
            // InternalRos2Parser.g:853:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:859:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:860:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:860:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:861:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubscriberRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getSubscriberAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:890:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:891:4: ( ruleEString )
            {
            // InternalRos2Parser.g:891:4: ( ruleEString )
            // InternalRos2Parser.g:892:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:906:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Ns) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRos2Parser.g:907:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getSubscriberAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:911:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:912:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:912:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:913:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:931:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Qos) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRos2Parser.g:932:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getSubscriberAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:936:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:937:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:937:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:938:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getSubscriberAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubscriber"


    // $ANTLR start "entryRuleServiceServer"
    // InternalRos2Parser.g:964:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRos2Parser.g:964:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRos2Parser.g:965:2: iv_ruleServiceServer= ruleServiceServer EOF
            {
             newCompositeNode(grammarAccess.getServiceServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceServer=ruleServiceServer();

            state._fsp--;

             current =iv_ruleServiceServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceServer"


    // $ANTLR start "ruleServiceServer"
    // InternalRos2Parser.g:971:1: ruleServiceServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleServiceServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:977:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:978:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:978:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:979:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:979:3: ()
            // InternalRos2Parser.g:980:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:986:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:987:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:987:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:988:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceServerAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:1017:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:1018:4: ( ruleEString )
            {
            // InternalRos2Parser.g:1018:4: ( ruleEString )
            // InternalRos2Parser.g:1019:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:1033:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Ns) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRos2Parser.g:1034:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:1038:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:1039:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:1039:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:1040:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1058:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Qos) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRos2Parser.g:1059:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getServiceServerAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:1063:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:1064:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:1064:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:1065:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getServiceServerAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceServer"


    // $ANTLR start "entryRuleServiceClient"
    // InternalRos2Parser.g:1091:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRos2Parser.g:1091:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRos2Parser.g:1092:2: iv_ruleServiceClient= ruleServiceClient EOF
            {
             newCompositeNode(grammarAccess.getServiceClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceClient=ruleServiceClient();

            state._fsp--;

             current =iv_ruleServiceClient; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceClient"


    // $ANTLR start "ruleServiceClient"
    // InternalRos2Parser.g:1098:1: ruleServiceClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleServiceClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1104:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:1105:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:1105:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:1106:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:1106:3: ()
            // InternalRos2Parser.g:1107:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1113:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:1114:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:1114:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:1115:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceClientRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceClientAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:1144:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:1145:4: ( ruleEString )
            {
            // InternalRos2Parser.g:1145:4: ( ruleEString )
            // InternalRos2Parser.g:1146:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:1160:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Ns) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRos2Parser.g:1161:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:1165:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:1166:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:1166:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:1167:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1185:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Qos) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRos2Parser.g:1186:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getServiceClientAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:1190:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:1191:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:1191:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:1192:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getServiceClientAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceClient"


    // $ANTLR start "entryRuleActionServer"
    // InternalRos2Parser.g:1218:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRos2Parser.g:1218:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRos2Parser.g:1219:2: iv_ruleActionServer= ruleActionServer EOF
            {
             newCompositeNode(grammarAccess.getActionServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionServer=ruleActionServer();

            state._fsp--;

             current =iv_ruleActionServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionServer"


    // $ANTLR start "ruleActionServer"
    // InternalRos2Parser.g:1225:1: ruleActionServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleActionServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1231:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:1232:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:1232:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:1233:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:1233:3: ()
            // InternalRos2Parser.g:1234:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1240:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:1241:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:1241:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:1242:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionServerAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:1271:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:1272:4: ( ruleEString )
            {
            // InternalRos2Parser.g:1272:4: ( ruleEString )
            // InternalRos2Parser.g:1273:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:1287:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Ns) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRos2Parser.g:1288:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:1292:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:1293:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:1293:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:1294:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1312:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Qos) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRos2Parser.g:1313:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getActionServerAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:1317:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:1318:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:1318:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:1319:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionServerRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getActionServerAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionServer"


    // $ANTLR start "entryRuleActionClient"
    // InternalRos2Parser.g:1345:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRos2Parser.g:1345:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRos2Parser.g:1346:2: iv_ruleActionClient= ruleActionClient EOF
            {
             newCompositeNode(grammarAccess.getActionClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionClient=ruleActionClient();

            state._fsp--;

             current =iv_ruleActionClient; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionClient"


    // $ANTLR start "ruleActionClient"
    // InternalRos2Parser.g:1352:1: ruleActionClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleActionClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_qos_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1358:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END ) )
            // InternalRos2Parser.g:1359:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            {
            // InternalRos2Parser.g:1359:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END )
            // InternalRos2Parser.g:1360:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )? this_END_10= RULE_END
            {
            // InternalRos2Parser.g:1360:3: ()
            // InternalRos2Parser.g:1361:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1367:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:1368:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:1368:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:1369:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionClientRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionClientAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:1398:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:1399:4: ( ruleEString )
            {
            // InternalRos2Parser.g:1399:4: ( ruleEString )
            // InternalRos2Parser.g:1400:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:1414:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Ns) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRos2Parser.g:1415:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:1419:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:1420:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:1420:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:1421:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1439:3: (otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Qos) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRos2Parser.g:1440:4: otherlv_8= Qos ( (lv_qos_9_0= ruleQualityOfService ) )
                    {
                    otherlv_8=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getActionClientAccess().getQosKeyword_7_0());
                    			
                    // InternalRos2Parser.g:1444:4: ( (lv_qos_9_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:1445:5: (lv_qos_9_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:1445:5: (lv_qos_9_0= ruleQualityOfService )
                    // InternalRos2Parser.g:1446:6: lv_qos_9_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getQosQualityOfServiceParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_9_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionClientRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_9_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getActionClientAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionClient"


    // $ANTLR start "entryRuleParameter"
    // InternalRos2Parser.g:1472:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRos2Parser.g:1472:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRos2Parser.g:1473:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalRos2Parser.g:1479:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( (lv_type_5_0= ruleParameterType ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )? this_END_12= RULE_END ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token this_END_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_namespace_7_0 = null;

        EObject lv_value_9_0 = null;

        EObject lv_qos_11_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1485:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( (lv_type_5_0= ruleParameterType ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )? this_END_12= RULE_END ) )
            // InternalRos2Parser.g:1486:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( (lv_type_5_0= ruleParameterType ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )? this_END_12= RULE_END )
            {
            // InternalRos2Parser.g:1486:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( (lv_type_5_0= ruleParameterType ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )? this_END_12= RULE_END )
            // InternalRos2Parser.g:1487:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( (lv_type_5_0= ruleParameterType ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )? this_END_12= RULE_END
            {
            // InternalRos2Parser.g:1487:3: ()
            // InternalRos2Parser.g:1488:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1494:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:1495:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:1495:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:1496:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_26); 

            			newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getTypeKeyword_4());
            		
            // InternalRos2Parser.g:1525:3: ( (lv_type_5_0= ruleParameterType ) )
            // InternalRos2Parser.g:1526:4: (lv_type_5_0= ruleParameterType )
            {
            // InternalRos2Parser.g:1526:4: (lv_type_5_0= ruleParameterType )
            // InternalRos2Parser.g:1527:5: lv_type_5_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_type_5_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:1544:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Ns) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRos2Parser.g:1545:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getNsKeyword_6_0());
                    			
                    // InternalRos2Parser.g:1549:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos2Parser.g:1550:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos2Parser.g:1550:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos2Parser.g:1551:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1569:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Value_1) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRos2Parser.g:1570:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_29); 

                    				newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());
                    			
                    // InternalRos2Parser.g:1574:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRos2Parser.g:1575:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRos2Parser.g:1575:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRos2Parser.g:1576:6: lv_value_9_0= ruleParameterValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_value_9_0=ruleParameterValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_9_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1594:3: (otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Qos) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRos2Parser.g:1595:4: otherlv_10= Qos ( (lv_qos_11_0= ruleQualityOfService ) )
                    {
                    otherlv_10=(Token)match(input,Qos,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getParameterAccess().getQosKeyword_8_0());
                    			
                    // InternalRos2Parser.g:1599:4: ( (lv_qos_11_0= ruleQualityOfService ) )
                    // InternalRos2Parser.g:1600:5: (lv_qos_11_0= ruleQualityOfService )
                    {
                    // InternalRos2Parser.g:1600:5: (lv_qos_11_0= ruleQualityOfService )
                    // InternalRos2Parser.g:1601:6: lv_qos_11_0= ruleQualityOfService
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getQosQualityOfServiceParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_qos_11_0=ruleQualityOfService();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"qos",
                    							lv_qos_11_0,
                    							"de.fraunhofer.ipa.ros2.Ros2.QualityOfService");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_12=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_12, grammarAccess.getParameterAccess().getENDTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRulePackage_Impl"
    // InternalRos2Parser.g:1627:1: entryRulePackage_Impl returns [EObject current=null] : iv_rulePackage_Impl= rulePackage_Impl EOF ;
    public final EObject entryRulePackage_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_Impl = null;


        try {
            // InternalRos2Parser.g:1627:53: (iv_rulePackage_Impl= rulePackage_Impl EOF )
            // InternalRos2Parser.g:1628:2: iv_rulePackage_Impl= rulePackage_Impl EOF
            {
             newCompositeNode(grammarAccess.getPackage_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackage_Impl=rulePackage_Impl();

            state._fsp--;

             current =iv_rulePackage_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_Impl"


    // $ANTLR start "rulePackage_Impl"
    // InternalRos2Parser.g:1634:1: rulePackage_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) ;
    public final EObject rulePackage_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token this_BEGIN_13=null;
        Token this_END_15=null;
        Token otherlv_16=null;
        Token this_BEGIN_17=null;
        Token this_END_19=null;
        Token otherlv_20=null;
        Token this_BEGIN_21=null;
        Token this_END_23=null;
        Token this_END_24=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_5_0 = null;

        EObject lv_dependency_8_0 = null;

        EObject lv_dependency_10_0 = null;

        EObject lv_spec_14_0 = null;

        EObject lv_spec_18_0 = null;

        EObject lv_spec_22_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1640:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) )
            // InternalRos2Parser.g:1641:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            {
            // InternalRos2Parser.g:1641:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            // InternalRos2Parser.g:1642:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END
            {
            // InternalRos2Parser.g:1642:3: ()
            // InternalRos2Parser.g:1643:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1649:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos2Parser.g:1650:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos2Parser.g:1650:4: (lv_name_1_0= ruleRosNames )
            // InternalRos2Parser.g:1651:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos2Parser.g:1676:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FromGitRepo) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRos2Parser.g:1677:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_4_0());
                    			
                    // InternalRos2Parser.g:1681:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRos2Parser.g:1682:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRos2Parser.g:1682:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRos2Parser.g:1683:6: lv_fromGitRepo_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_fromGitRepo_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						set(
                    							current,
                    							"fromGitRepo",
                    							lv_fromGitRepo_5_0,
                    							"de.fraunhofer.ipa.ros.Basics.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRos2Parser.g:1701:3: (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Dependencies) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRos2Parser.g:1702:4: otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalRos2Parser.g:1710:4: ( (lv_dependency_8_0= ruleDependency ) )
                    // InternalRos2Parser.g:1711:5: (lv_dependency_8_0= ruleDependency )
                    {
                    // InternalRos2Parser.g:1711:5: (lv_dependency_8_0= ruleDependency )
                    // InternalRos2Parser.g:1712:6: lv_dependency_8_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_dependency_8_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_8_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos2Parser.g:1729:4: (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==Comma) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalRos2Parser.g:1730:5: otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getPackage_ImplAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalRos2Parser.g:1734:5: ( (lv_dependency_10_0= ruleDependency ) )
                    	    // InternalRos2Parser.g:1735:6: (lv_dependency_10_0= ruleDependency )
                    	    {
                    	    // InternalRos2Parser.g:1735:6: (lv_dependency_10_0= ruleDependency )
                    	    // InternalRos2Parser.g:1736:7: lv_dependency_10_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_dependency_10_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_10_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Dependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_32); 

                    				newLeafNode(otherlv_11, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalRos2Parser.g:1759:3: ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )*
            loop36:
            do {
                int alt36=4;
                switch ( input.LA(1) ) {
                case Msgs:
                    {
                    alt36=1;
                    }
                    break;
                case Srvs:
                    {
                    alt36=2;
                    }
                    break;
                case Actions:
                    {
                    alt36=3;
                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // InternalRos2Parser.g:1760:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    {
            	    // InternalRos2Parser.g:1760:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    // InternalRos2Parser.g:1761:5: otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END
            	    {
            	    otherlv_12=(Token)match(input,Msgs,FOLLOW_4); 

            	    					newLeafNode(otherlv_12, grammarAccess.getPackage_ImplAccess().getMsgsKeyword_6_0_0());
            	    				
            	    this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_33); 

            	    					newLeafNode(this_BEGIN_13, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_0_1());
            	    				
            	    // InternalRos2Parser.g:1769:5: ( (lv_spec_14_0= ruleTopicSpec ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( ((LA33_0>=Header && LA33_0<=String)||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:1770:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    {
            	    	    // InternalRos2Parser.g:1770:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    // InternalRos2Parser.g:1771:7: lv_spec_14_0= ruleTopicSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecTopicSpecParserRuleCall_6_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_33);
            	    	    lv_spec_14_0=ruleTopicSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_14_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.TopicSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop33;
            	        }
            	    } while (true);

            	    this_END_15=(Token)match(input,RULE_END,FOLLOW_32); 

            	    					newLeafNode(this_END_15, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos2Parser.g:1794:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    {
            	    // InternalRos2Parser.g:1794:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    // InternalRos2Parser.g:1795:5: otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END
            	    {
            	    otherlv_16=(Token)match(input,Srvs,FOLLOW_4); 

            	    					newLeafNode(otherlv_16, grammarAccess.getPackage_ImplAccess().getSrvsKeyword_6_1_0());
            	    				
            	    this_BEGIN_17=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_17, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_1_1());
            	    				
            	    // InternalRos2Parser.g:1803:5: ( (lv_spec_18_0= ruleServiceSpec ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:1804:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    {
            	    	    // InternalRos2Parser.g:1804:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    // InternalRos2Parser.g:1805:7: lv_spec_18_0= ruleServiceSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecServiceSpecParserRuleCall_6_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_spec_18_0=ruleServiceSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_18_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop34;
            	        }
            	    } while (true);

            	    this_END_19=(Token)match(input,RULE_END,FOLLOW_32); 

            	    					newLeafNode(this_END_19, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos2Parser.g:1828:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    {
            	    // InternalRos2Parser.g:1828:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    // InternalRos2Parser.g:1829:5: otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END
            	    {
            	    otherlv_20=(Token)match(input,Actions,FOLLOW_4); 

            	    					newLeafNode(otherlv_20, grammarAccess.getPackage_ImplAccess().getActionsKeyword_6_2_0());
            	    				
            	    this_BEGIN_21=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_21, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_2_1());
            	    				
            	    // InternalRos2Parser.g:1837:5: ( (lv_spec_22_0= ruleActionSpec ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING)) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:1838:6: (lv_spec_22_0= ruleActionSpec )
            	    	    {
            	    	    // InternalRos2Parser.g:1838:6: (lv_spec_22_0= ruleActionSpec )
            	    	    // InternalRos2Parser.g:1839:7: lv_spec_22_0= ruleActionSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecActionSpecParserRuleCall_6_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_spec_22_0=ruleActionSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_22_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop35;
            	        }
            	    } while (true);

            	    this_END_23=(Token)match(input,RULE_END,FOLLOW_32); 

            	    					newLeafNode(this_END_23, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_2_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            this_END_24=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_24, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_Impl"


    // $ANTLR start "entryRuleTopicSpec"
    // InternalRos2Parser.g:1870:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRos2Parser.g:1870:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRos2Parser.g:1871:2: iv_ruleTopicSpec= ruleTopicSpec EOF
            {
             newCompositeNode(grammarAccess.getTopicSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopicSpec=ruleTopicSpec();

            state._fsp--;

             current =iv_ruleTopicSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopicSpec"


    // $ANTLR start "ruleTopicSpec"
    // InternalRos2Parser.g:1877:1: ruleTopicSpec returns [EObject current=null] : ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) ;
    public final EObject ruleTopicSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token this_END_7=null;
        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_message_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1883:2: ( ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) )
            // InternalRos2Parser.g:1884:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            {
            // InternalRos2Parser.g:1884:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            // InternalRos2Parser.g:1885:3: () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END
            {
            // InternalRos2Parser.g:1885:3: ()
            // InternalRos2Parser.g:1886:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:1892:3: ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) )
            // InternalRos2Parser.g:1893:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            {
            // InternalRos2Parser.g:1893:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            // InternalRos2Parser.g:1894:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            {
            // InternalRos2Parser.g:1894:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            int alt37=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt37=1;
                }
                break;
            case Header:
                {
                alt37=2;
                }
                break;
            case String:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalRos2Parser.g:1895:6: lv_name_1_1= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getNameEStringParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_name_1_1=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_1,
                    							"de.fraunhofer.ipa.ros.Basics.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:1911:6: lv_name_1_2= Header
                    {
                    lv_name_1_2=(Token)match(input,Header,FOLLOW_4); 

                    						newLeafNode(lv_name_1_2, grammarAccess.getTopicSpecAccess().getNameHeaderKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopicSpecRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:1922:6: lv_name_1_3= String
                    {
                    lv_name_1_3=(Token)match(input,String,FOLLOW_4); 

                    						newLeafNode(lv_name_1_3, grammarAccess.getTopicSpecAccess().getNameStringKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopicSpecRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_3, null);
                    					

                    }
                    break;

            }


            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_35); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Message,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getTopicSpecAccess().getMessageKeyword_3());
            		
            // InternalRos2Parser.g:1943:3: (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_BEGIN) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRos2Parser.g:1944:4: this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos2Parser.g:1948:4: ( (lv_message_5_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:1949:5: (lv_message_5_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:1949:5: (lv_message_5_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:1950:6: lv_message_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getMessageMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_message_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                    						}
                    						set(
                    							current,
                    							"message",
                    							lv_message_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_13); 

                    				newLeafNode(this_END_6, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            this_END_7=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_7, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopicSpec"


    // $ANTLR start "entryRuleServiceSpec"
    // InternalRos2Parser.g:1980:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRos2Parser.g:1980:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRos2Parser.g:1981:2: iv_ruleServiceSpec= ruleServiceSpec EOF
            {
             newCompositeNode(grammarAccess.getServiceSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceSpec=ruleServiceSpec();

            state._fsp--;

             current =iv_ruleServiceSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceSpec"


    // $ANTLR start "ruleServiceSpec"
    // InternalRos2Parser.g:1987:1: ruleServiceSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) ;
    public final EObject ruleServiceSpec() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token this_END_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_request_5_0 = null;

        EObject lv_response_9_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:1993:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) )
            // InternalRos2Parser.g:1994:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            {
            // InternalRos2Parser.g:1994:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            // InternalRos2Parser.g:1995:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END
            {
            // InternalRos2Parser.g:1995:3: ()
            // InternalRos2Parser.g:1996:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:2002:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:2003:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:2003:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:2004:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceSpecRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_38); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Request,FOLLOW_39); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceSpecAccess().getRequestKeyword_3());
            		
            // InternalRos2Parser.g:2029:3: (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_BEGIN) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRos2Parser.g:2030:4: this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos2Parser.g:2034:4: ( (lv_request_5_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:2035:5: (lv_request_5_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:2035:5: (lv_request_5_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:2036:6: lv_request_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getRequestMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_request_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                    						}
                    						set(
                    							current,
                    							"request",
                    							lv_request_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_40); 

                    				newLeafNode(this_END_6, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Response,FOLLOW_36); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceSpecAccess().getResponseKeyword_5());
            		
            // InternalRos2Parser.g:2062:3: (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_BEGIN) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalRos2Parser.g:2063:4: this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos2Parser.g:2067:4: ( (lv_response_9_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:2068:5: (lv_response_9_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:2068:5: (lv_response_9_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:2069:6: lv_response_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getResponseMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_response_9_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                    						}
                    						set(
                    							current,
                    							"response",
                    							lv_response_9_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_13); 

                    				newLeafNode(this_END_10, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_6_2());
                    			

                    }
                    break;

            }

            this_END_11=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_11, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceSpec"


    // $ANTLR start "entryRuleActionSpec"
    // InternalRos2Parser.g:2099:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRos2Parser.g:2099:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRos2Parser.g:2100:2: iv_ruleActionSpec= ruleActionSpec EOF
            {
             newCompositeNode(grammarAccess.getActionSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionSpec=ruleActionSpec();

            state._fsp--;

             current =iv_ruleActionSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionSpec"


    // $ANTLR start "ruleActionSpec"
    // InternalRos2Parser.g:2106:1: ruleActionSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) ;
    public final EObject ruleActionSpec() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token otherlv_11=null;
        Token this_BEGIN_12=null;
        Token this_END_14=null;
        Token this_END_15=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_goal_5_0 = null;

        EObject lv_result_9_0 = null;

        EObject lv_feedback_13_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2112:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) )
            // InternalRos2Parser.g:2113:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            {
            // InternalRos2Parser.g:2113:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            // InternalRos2Parser.g:2114:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END
            {
            // InternalRos2Parser.g:2114:3: ()
            // InternalRos2Parser.g:2115:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:2121:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos2Parser.g:2122:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos2Parser.g:2122:4: (lv_name_1_0= ruleEString )
            // InternalRos2Parser.g:2123:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionSpecRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_41); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Goal,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getActionSpecAccess().getGoalKeyword_3());
            		
            // InternalRos2Parser.g:2148:3: (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_BEGIN) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRos2Parser.g:2149:4: this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos2Parser.g:2153:4: ( (lv_goal_5_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:2154:5: (lv_goal_5_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:2154:5: (lv_goal_5_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:2155:6: lv_goal_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getGoalMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_goal_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"goal",
                    							lv_goal_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_43); 

                    				newLeafNode(this_END_6, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Result,FOLLOW_44); 

            			newLeafNode(otherlv_7, grammarAccess.getActionSpecAccess().getResultKeyword_5());
            		
            // InternalRos2Parser.g:2181:3: (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_BEGIN) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRos2Parser.g:2182:4: this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos2Parser.g:2186:4: ( (lv_result_9_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:2187:5: (lv_result_9_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:2187:5: (lv_result_9_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:2188:6: lv_result_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getResultMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_result_9_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"result",
                    							lv_result_9_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_45); 

                    				newLeafNode(this_END_10, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_6_2());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,Feedback,FOLLOW_36); 

            			newLeafNode(otherlv_11, grammarAccess.getActionSpecAccess().getFeedbackKeyword_7());
            		
            // InternalRos2Parser.g:2214:3: (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_BEGIN) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRos2Parser.g:2215:4: this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END
                    {
                    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_37); 

                    				newLeafNode(this_BEGIN_12, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());
                    			
                    // InternalRos2Parser.g:2219:4: ( (lv_feedback_13_0= ruleMessageDefinition ) )
                    // InternalRos2Parser.g:2220:5: (lv_feedback_13_0= ruleMessageDefinition )
                    {
                    // InternalRos2Parser.g:2220:5: (lv_feedback_13_0= ruleMessageDefinition )
                    // InternalRos2Parser.g:2221:6: lv_feedback_13_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getFeedbackMessageDefinitionParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_feedback_13_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"feedback",
                    							lv_feedback_13_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_14=(Token)match(input,RULE_END,FOLLOW_13); 

                    				newLeafNode(this_END_14, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_8_2());
                    			

                    }
                    break;

            }

            this_END_15=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_15, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionSpec"


    // $ANTLR start "entryRuleMessageDefinition"
    // InternalRos2Parser.g:2251:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRos2Parser.g:2251:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRos2Parser.g:2252:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
            {
             newCompositeNode(grammarAccess.getMessageDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageDefinition=ruleMessageDefinition();

            state._fsp--;

             current =iv_ruleMessageDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageDefinition"


    // $ANTLR start "ruleMessageDefinition"
    // InternalRos2Parser.g:2258:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2264:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRos2Parser.g:2265:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRos2Parser.g:2265:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRos2Parser.g:2266:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRos2Parser.g:2266:3: ()
            // InternalRos2Parser.g:2267:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:2273:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=Float32_1 && LA44_0<=Float64_1)||LA44_0==Duration||(LA44_0>=String_2 && LA44_0<=Uint64_1)||(LA44_0>=Float32 && LA44_0<=Int64_1)||LA44_0==Uint8_1||LA44_0==Header||(LA44_0>=Bool_1 && LA44_0<=Char_1)||LA44_0==Int8_1||(LA44_0>=String_1 && LA44_0<=Uint64)||(LA44_0>=Int16 && LA44_0<=Int64)||LA44_0==Uint8||(LA44_0>=Bool && LA44_0<=Char)||LA44_0==Int8||LA44_0==Time||(LA44_0>=RULE_ID && LA44_0<=RULE_STRING)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalRos2Parser.g:2274:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    {
            	    // InternalRos2Parser.g:2274:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    // InternalRos2Parser.g:2275:5: lv_MessagePart_1_0= ruleMessagePart
            	    {

            	    					newCompositeNode(grammarAccess.getMessageDefinitionAccess().getMessagePartMessagePartParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_MessagePart_1_0=ruleMessagePart();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMessageDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"MessagePart",
            	    						lv_MessagePart_1_0,
            	    						"de.fraunhofer.ipa.ros.Basics.MessagePart");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageDefinition"


    // $ANTLR start "entryRuleArtifact"
    // InternalRos2Parser.g:2296:1: entryRuleArtifact returns [EObject current=null] : iv_ruleArtifact= ruleArtifact EOF ;
    public final EObject entryRuleArtifact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtifact = null;


        try {
            // InternalRos2Parser.g:2296:49: (iv_ruleArtifact= ruleArtifact EOF )
            // InternalRos2Parser.g:2297:2: iv_ruleArtifact= ruleArtifact EOF
            {
             newCompositeNode(grammarAccess.getArtifactRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtifact=ruleArtifact();

            state._fsp--;

             current =iv_ruleArtifact; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArtifact"


    // $ANTLR start "ruleArtifact"
    // InternalRos2Parser.g:2303:1: ruleArtifact returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? this_END_5= RULE_END ) ;
    public final EObject ruleArtifact() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_node_4_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2309:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? this_END_5= RULE_END ) )
            // InternalRos2Parser.g:2310:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? this_END_5= RULE_END )
            {
            // InternalRos2Parser.g:2310:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? this_END_5= RULE_END )
            // InternalRos2Parser.g:2311:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? this_END_5= RULE_END
            {
            // InternalRos2Parser.g:2311:3: ()
            // InternalRos2Parser.g:2312:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArtifactAccess().getArtifactAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:2318:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos2Parser.g:2319:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos2Parser.g:2319:4: (lv_name_1_0= ruleRosNames )
            // InternalRos2Parser.g:2320:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getArtifactAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArtifactRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getArtifactAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_47); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getArtifactAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos2Parser.g:2345:3: ( (lv_node_4_0= ruleNode ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Node_1) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRos2Parser.g:2346:4: (lv_node_4_0= ruleNode )
                    {
                    // InternalRos2Parser.g:2346:4: (lv_node_4_0= ruleNode )
                    // InternalRos2Parser.g:2347:5: lv_node_4_0= ruleNode
                    {

                    					newCompositeNode(grammarAccess.getArtifactAccess().getNodeNodeParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_13);
                    lv_node_4_0=ruleNode();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getArtifactRule());
                    					}
                    					set(
                    						current,
                    						"node",
                    						lv_node_4_0,
                    						"de.fraunhofer.ipa.ros.Ros.Node");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_5, grammarAccess.getArtifactAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArtifact"


    // $ANTLR start "entryRuleNode"
    // InternalRos2Parser.g:2372:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRos2Parser.g:2372:45: (iv_ruleNode= ruleNode EOF )
            // InternalRos2Parser.g:2373:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalRos2Parser.g:2379:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token this_BEGIN_11=null;
        Token this_END_13=null;
        Token otherlv_14=null;
        Token this_BEGIN_15=null;
        Token this_END_17=null;
        Token otherlv_18=null;
        Token this_BEGIN_19=null;
        Token this_END_21=null;
        Token otherlv_22=null;
        Token this_BEGIN_23=null;
        Token this_END_25=null;
        Token otherlv_26=null;
        Token this_BEGIN_27=null;
        Token this_END_29=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_publisher_4_0 = null;

        EObject lv_subscriber_8_0 = null;

        EObject lv_serviceserver_12_0 = null;

        EObject lv_serviceclient_16_0 = null;

        EObject lv_actionserver_20_0 = null;

        EObject lv_actionclient_24_0 = null;

        EObject lv_parameter_28_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2385:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* ) )
            // InternalRos2Parser.g:2386:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* )
            {
            // InternalRos2Parser.g:2386:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* )
            // InternalRos2Parser.g:2387:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalRos2Parser.g:2391:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos2Parser.g:2392:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos2Parser.g:2392:4: (lv_name_1_0= ruleRosNames )
            // InternalRos2Parser.g:2393:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_49);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Basics.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:2410:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )*
            loop53:
            do {
                int alt53=8;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt53=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt53=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt53=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt53=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt53=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt53=6;
                    }
                    break;
                case Parameters:
                    {
                    alt53=7;
                    }
                    break;

                }

                switch (alt53) {
            	case 1 :
            	    // InternalRos2Parser.g:2411:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2411:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    // InternalRos2Parser.g:2412:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
            	    {
            	    otherlv_2=(Token)match(input,Publishers,FOLLOW_4); 

            	    					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());
            	    				
            	    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());
            	    				
            	    // InternalRos2Parser.g:2420:5: ( (lv_publisher_4_0= rulePublisher ) )*
            	    loop46:
            	    do {
            	        int alt46=2;
            	        int LA46_0 = input.LA(1);

            	        if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)) ) {
            	            alt46=1;
            	        }


            	        switch (alt46) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2421:6: (lv_publisher_4_0= rulePublisher )
            	    	    {
            	    	    // InternalRos2Parser.g:2421:6: (lv_publisher_4_0= rulePublisher )
            	    	    // InternalRos2Parser.g:2422:7: lv_publisher_4_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_publisher_4_0=rulePublisher();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"publisher",
            	    	    								lv_publisher_4_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.Publisher");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop46;
            	        }
            	    } while (true);

            	    this_END_5=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos2Parser.g:2445:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2445:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    // InternalRos2Parser.g:2446:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,Subscribers,FOLLOW_4); 

            	    					newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());
            	    				
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());
            	    				
            	    // InternalRos2Parser.g:2454:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
            	    loop47:
            	    do {
            	        int alt47=2;
            	        int LA47_0 = input.LA(1);

            	        if ( ((LA47_0>=RULE_ID && LA47_0<=RULE_STRING)) ) {
            	            alt47=1;
            	        }


            	        switch (alt47) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2455:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRos2Parser.g:2455:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    // InternalRos2Parser.g:2456:7: lv_subscriber_8_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_subscriber_8_0=ruleSubscriber();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"subscriber",
            	    	    								lv_subscriber_8_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.Subscriber");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop47;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos2Parser.g:2479:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2479:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    // InternalRos2Parser.g:2480:5: otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Serviceservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserversKeyword_2_2_0());
            	    				
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());
            	    				
            	    // InternalRos2Parser.g:2488:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
            	    loop48:
            	    do {
            	        int alt48=2;
            	        int LA48_0 = input.LA(1);

            	        if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_STRING)) ) {
            	            alt48=1;
            	        }


            	        switch (alt48) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2489:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRos2Parser.g:2489:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    // InternalRos2Parser.g:2490:7: lv_serviceserver_12_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_serviceserver_12_0=ruleServiceServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceserver",
            	    	    								lv_serviceserver_12_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.ServiceServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop48;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos2Parser.g:2513:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2513:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    // InternalRos2Parser.g:2514:5: otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Serviceclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientsKeyword_2_3_0());
            	    				
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());
            	    				
            	    // InternalRos2Parser.g:2522:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
            	    loop49:
            	    do {
            	        int alt49=2;
            	        int LA49_0 = input.LA(1);

            	        if ( ((LA49_0>=RULE_ID && LA49_0<=RULE_STRING)) ) {
            	            alt49=1;
            	        }


            	        switch (alt49) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2523:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRos2Parser.g:2523:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    // InternalRos2Parser.g:2524:7: lv_serviceclient_16_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_serviceclient_16_0=ruleServiceClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceclient",
            	    	    								lv_serviceclient_16_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.ServiceClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop49;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos2Parser.g:2547:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2547:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    // InternalRos2Parser.g:2548:5: otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Actionservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserversKeyword_2_4_0());
            	    				
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());
            	    				
            	    // InternalRos2Parser.g:2556:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
            	    loop50:
            	    do {
            	        int alt50=2;
            	        int LA50_0 = input.LA(1);

            	        if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_STRING)) ) {
            	            alt50=1;
            	        }


            	        switch (alt50) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2557:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    {
            	    	    // InternalRos2Parser.g:2557:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    // InternalRos2Parser.g:2558:7: lv_actionserver_20_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_actionserver_20_0=ruleActionServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionserver",
            	    	    								lv_actionserver_20_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.ActionServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop50;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos2Parser.g:2581:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2581:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    // InternalRos2Parser.g:2582:5: otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Actionclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientsKeyword_2_5_0());
            	    				
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());
            	    				
            	    // InternalRos2Parser.g:2590:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
            	    loop51:
            	    do {
            	        int alt51=2;
            	        int LA51_0 = input.LA(1);

            	        if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)) ) {
            	            alt51=1;
            	        }


            	        switch (alt51) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2591:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    {
            	    	    // InternalRos2Parser.g:2591:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    // InternalRos2Parser.g:2592:7: lv_actionclient_24_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_actionclient_24_0=ruleActionClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionclient",
            	    	    								lv_actionclient_24_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.ActionClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop51;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos2Parser.g:2615:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    {
            	    // InternalRos2Parser.g:2615:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    // InternalRos2Parser.g:2616:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
            	    {
            	    otherlv_26=(Token)match(input,Parameters,FOLLOW_4); 

            	    					newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());
            	    				
            	    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());
            	    				
            	    // InternalRos2Parser.g:2624:5: ( (lv_parameter_28_0= ruleParameter ) )*
            	    loop52:
            	    do {
            	        int alt52=2;
            	        int LA52_0 = input.LA(1);

            	        if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_STRING)) ) {
            	            alt52=1;
            	        }


            	        switch (alt52) {
            	    	case 1 :
            	    	    // InternalRos2Parser.g:2625:6: (lv_parameter_28_0= ruleParameter )
            	    	    {
            	    	    // InternalRos2Parser.g:2625:6: (lv_parameter_28_0= ruleParameter )
            	    	    // InternalRos2Parser.g:2626:7: lv_parameter_28_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
            	    	    lv_parameter_28_0=ruleParameter();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"parameter",
            	    	    								lv_parameter_28_0,
            	    	    								"de.fraunhofer.ipa.ros2.Ros2.Parameter");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop52;
            	        }
            	    } while (true);

            	    this_END_29=(Token)match(input,RULE_END,FOLLOW_49); 

            	    					newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleDependency"
    // InternalRos2Parser.g:2653:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRos2Parser.g:2653:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRos2Parser.g:2654:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalRos2Parser.g:2660:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2666:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRos2Parser.g:2667:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRos2Parser.g:2667:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_STRING)) ) {
                alt54=1;
            }
            else if ( (LA54_0==ExternalDependency) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalRos2Parser.g:2668:3: this_PackageDependency_0= rulePackageDependency
                    {

                    			newCompositeNode(grammarAccess.getDependencyAccess().getPackageDependencyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PackageDependency_0=rulePackageDependency();

                    state._fsp--;


                    			current = this_PackageDependency_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:2677:3: this_ExternalDependency_1= ruleExternalDependency
                    {

                    			newCompositeNode(grammarAccess.getDependencyAccess().getExternalDependencyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExternalDependency_1=ruleExternalDependency();

                    state._fsp--;


                    			current = this_ExternalDependency_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRulePackageDependency"
    // InternalRos2Parser.g:2689:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRos2Parser.g:2689:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRos2Parser.g:2690:2: iv_rulePackageDependency= rulePackageDependency EOF
            {
             newCompositeNode(grammarAccess.getPackageDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDependency=rulePackageDependency();

            state._fsp--;

             current =iv_rulePackageDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDependency"


    // $ANTLR start "rulePackageDependency"
    // InternalRos2Parser.g:2696:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos2Parser.g:2702:2: ( ( ( ruleEString ) ) )
            // InternalRos2Parser.g:2703:2: ( ( ruleEString ) )
            {
            // InternalRos2Parser.g:2703:2: ( ( ruleEString ) )
            // InternalRos2Parser.g:2704:3: ( ruleEString )
            {
            // InternalRos2Parser.g:2704:3: ( ruleEString )
            // InternalRos2Parser.g:2705:4: ruleEString
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPackageDependencyRule());
            				}
            			

            				newCompositeNode(grammarAccess.getPackageDependencyAccess().getPackagePackageCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDependency"


    // $ANTLR start "entryRuleExternalDependency"
    // InternalRos2Parser.g:2722:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRos2Parser.g:2722:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRos2Parser.g:2723:2: iv_ruleExternalDependency= ruleExternalDependency EOF
            {
             newCompositeNode(grammarAccess.getExternalDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalDependency=ruleExternalDependency();

            state._fsp--;

             current =iv_ruleExternalDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalDependency"


    // $ANTLR start "ruleExternalDependency"
    // InternalRos2Parser.g:2729:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2735:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRos2Parser.g:2736:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRos2Parser.g:2736:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRos2Parser.g:2737:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRos2Parser.g:2737:3: ()
            // InternalRos2Parser.g:2738:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRos2Parser.g:2748:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRos2Parser.g:2749:4: (lv_name_2_0= ruleEString )
            {
            // InternalRos2Parser.g:2749:4: (lv_name_2_0= ruleEString )
            // InternalRos2Parser.g:2750:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExternalDependencyAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalDependencyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalDependency"


    // $ANTLR start "entryRuleNamespace"
    // InternalRos2Parser.g:2771:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRos2Parser.g:2771:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRos2Parser.g:2772:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalRos2Parser.g:2778:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2784:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRos2Parser.g:2785:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRos2Parser.g:2785:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt55=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt55=1;
                }
                break;
            case RelativeNamespace:
                {
                alt55=2;
                }
                break;
            case PrivateNamespace:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalRos2Parser.g:2786:3: this_GlobalNamespace_0= ruleGlobalNamespace
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GlobalNamespace_0=ruleGlobalNamespace();

                    state._fsp--;


                    			current = this_GlobalNamespace_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:2795:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RelativeNamespace_Impl_1=ruleRelativeNamespace_Impl();

                    state._fsp--;


                    			current = this_RelativeNamespace_Impl_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:2804:3: this_PrivateNamespace_2= rulePrivateNamespace
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrivateNamespace_2=rulePrivateNamespace();

                    state._fsp--;


                    			current = this_PrivateNamespace_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleGraphName"
    // InternalRos2Parser.g:2816:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRos2Parser.g:2816:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRos2Parser.g:2817:2: iv_ruleGraphName= ruleGraphName EOF
            {
             newCompositeNode(grammarAccess.getGraphNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGraphName=ruleGraphName();

            state._fsp--;

             current =iv_ruleGraphName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphName"


    // $ANTLR start "ruleGraphName"
    // InternalRos2Parser.g:2823:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:2829:2: (kw= GraphName )
            // InternalRos2Parser.g:2830:2: kw= GraphName
            {
            kw=(Token)match(input,GraphName,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getGraphNameAccess().getGraphNameKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphName"


    // $ANTLR start "entryRuleGlobalNamespace"
    // InternalRos2Parser.g:2838:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRos2Parser.g:2838:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRos2Parser.g:2839:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
            {
             newCompositeNode(grammarAccess.getGlobalNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalNamespace=ruleGlobalNamespace();

            state._fsp--;

             current =iv_ruleGlobalNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalNamespace"


    // $ANTLR start "ruleGlobalNamespace"
    // InternalRos2Parser.g:2845:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2851:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos2Parser.g:2852:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos2Parser.g:2852:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos2Parser.g:2853:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos2Parser.g:2853:3: ()
            // InternalRos2Parser.g:2854:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRos2Parser.g:2864:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LeftSquareBracket) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRos2Parser.g:2865:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_51); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos2Parser.g:2869:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos2Parser.g:2870:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos2Parser.g:2870:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos2Parser.g:2871:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.GraphName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos2Parser.g:2888:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==Comma) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalRos2Parser.g:2889:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_51); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos2Parser.g:2893:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos2Parser.g:2894:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos2Parser.g:2894:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos2Parser.g:2895:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parts",
                    	    								lv_parts_5_0,
                    	    								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalNamespace"


    // $ANTLR start "entryRuleRelativeNamespace_Impl"
    // InternalRos2Parser.g:2922:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRos2Parser.g:2922:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRos2Parser.g:2923:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
            {
             newCompositeNode(grammarAccess.getRelativeNamespace_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelativeNamespace_Impl=ruleRelativeNamespace_Impl();

            state._fsp--;

             current =iv_ruleRelativeNamespace_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelativeNamespace_Impl"


    // $ANTLR start "ruleRelativeNamespace_Impl"
    // InternalRos2Parser.g:2929:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:2935:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos2Parser.g:2936:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos2Parser.g:2936:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos2Parser.g:2937:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos2Parser.g:2937:3: ()
            // InternalRos2Parser.g:2938:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRos2Parser.g:2948:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==LeftSquareBracket) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRos2Parser.g:2949:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_51); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos2Parser.g:2953:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos2Parser.g:2954:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos2Parser.g:2954:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos2Parser.g:2955:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.GraphName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos2Parser.g:2972:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==Comma) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalRos2Parser.g:2973:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_51); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos2Parser.g:2977:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos2Parser.g:2978:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos2Parser.g:2978:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos2Parser.g:2979:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parts",
                    	    								lv_parts_5_0,
                    	    								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelativeNamespace_Impl"


    // $ANTLR start "entryRulePrivateNamespace"
    // InternalRos2Parser.g:3006:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRos2Parser.g:3006:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRos2Parser.g:3007:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
            {
             newCompositeNode(grammarAccess.getPrivateNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrivateNamespace=rulePrivateNamespace();

            state._fsp--;

             current =iv_rulePrivateNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrivateNamespace"


    // $ANTLR start "rulePrivateNamespace"
    // InternalRos2Parser.g:3013:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject rulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3019:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos2Parser.g:3020:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos2Parser.g:3020:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos2Parser.g:3021:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos2Parser.g:3021:3: ()
            // InternalRos2Parser.g:3022:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRos2Parser.g:3032:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LeftSquareBracket) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRos2Parser.g:3033:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_51); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3037:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos2Parser.g:3038:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos2Parser.g:3038:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos2Parser.g:3039:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.GraphName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos2Parser.g:3056:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==Comma) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalRos2Parser.g:3057:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_51); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos2Parser.g:3061:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos2Parser.g:3062:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos2Parser.g:3062:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos2Parser.g:3063:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parts",
                    	    								lv_parts_5_0,
                    	    								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrivateNamespace"


    // $ANTLR start "entryRuleParameterType"
    // InternalRos2Parser.g:3090:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRos2Parser.g:3090:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRos2Parser.g:3091:2: iv_ruleParameterType= ruleParameterType EOF
            {
             newCompositeNode(grammarAccess.getParameterTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;

             current =iv_ruleParameterType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalRos2Parser.g:3097:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterListType_0 = null;

        EObject this_ParameterStructType_1 = null;

        EObject this_ParameterIntegerType_2 = null;

        EObject this_ParameterStringType_3 = null;

        EObject this_ParameterDoubleType_4 = null;

        EObject this_ParameterBooleanType_5 = null;

        EObject this_ParameterBase64Type_6 = null;

        EObject this_ParameterArrayType_7 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3103:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRos2Parser.g:3104:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRos2Parser.g:3104:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt62=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt62=1;
                }
                break;
            case Struct:
                {
                alt62=2;
                }
                break;
            case Integer:
                {
                alt62=3;
                }
                break;
            case String:
                {
                alt62=4;
                }
                break;
            case Double:
                {
                alt62=5;
                }
                break;
            case Boolean:
                {
                alt62=6;
                }
                break;
            case Base64:
                {
                alt62=7;
                }
                break;
            case Array:
                {
                alt62=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalRos2Parser.g:3105:3: this_ParameterListType_0= ruleParameterListType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterListType_0=ruleParameterListType();

                    state._fsp--;


                    			current = this_ParameterListType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:3114:3: this_ParameterStructType_1= ruleParameterStructType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStructType_1=ruleParameterStructType();

                    state._fsp--;


                    			current = this_ParameterStructType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:3123:3: this_ParameterIntegerType_2= ruleParameterIntegerType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterIntegerType_2=ruleParameterIntegerType();

                    state._fsp--;


                    			current = this_ParameterIntegerType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRos2Parser.g:3132:3: this_ParameterStringType_3= ruleParameterStringType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStringType_3=ruleParameterStringType();

                    state._fsp--;


                    			current = this_ParameterStringType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRos2Parser.g:3141:3: this_ParameterDoubleType_4= ruleParameterDoubleType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterDoubleType_4=ruleParameterDoubleType();

                    state._fsp--;


                    			current = this_ParameterDoubleType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRos2Parser.g:3150:3: this_ParameterBooleanType_5= ruleParameterBooleanType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBooleanType_5=ruleParameterBooleanType();

                    state._fsp--;


                    			current = this_ParameterBooleanType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRos2Parser.g:3159:3: this_ParameterBase64Type_6= ruleParameterBase64Type
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64Type_6=ruleParameterBase64Type();

                    state._fsp--;


                    			current = this_ParameterBase64Type_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRos2Parser.g:3168:3: this_ParameterArrayType_7= ruleParameterArrayType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterArrayType_7=ruleParameterArrayType();

                    state._fsp--;


                    			current = this_ParameterArrayType_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleParameterValue"
    // InternalRos2Parser.g:3180:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRos2Parser.g:3180:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRos2Parser.g:3181:2: iv_ruleParameterValue= ruleParameterValue EOF
            {
             newCompositeNode(grammarAccess.getParameterValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterValue=ruleParameterValue();

            state._fsp--;

             current =iv_ruleParameterValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterValue"


    // $ANTLR start "ruleParameterValue"
    // InternalRos2Parser.g:3187:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
    public final EObject ruleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterString_0 = null;

        EObject this_ParameterBase64_1 = null;

        EObject this_ParameterInteger_2 = null;

        EObject this_ParameterDouble_3 = null;

        EObject this_ParameterBoolean_4 = null;

        EObject this_ParameterList_5 = null;

        EObject this_ParameterStruct_6 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3193:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRos2Parser.g:3194:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRos2Parser.g:3194:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt63=7;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // InternalRos2Parser.g:3195:3: this_ParameterString_0= ruleParameterString
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterString_0=ruleParameterString();

                    state._fsp--;


                    			current = this_ParameterString_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:3204:3: this_ParameterBase64_1= ruleParameterBase64
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64_1=ruleParameterBase64();

                    state._fsp--;


                    			current = this_ParameterBase64_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:3213:3: this_ParameterInteger_2= ruleParameterInteger
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterInteger_2=ruleParameterInteger();

                    state._fsp--;


                    			current = this_ParameterInteger_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRos2Parser.g:3222:3: this_ParameterDouble_3= ruleParameterDouble
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterDouble_3=ruleParameterDouble();

                    state._fsp--;


                    			current = this_ParameterDouble_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRos2Parser.g:3231:3: this_ParameterBoolean_4= ruleParameterBoolean
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBoolean_4=ruleParameterBoolean();

                    state._fsp--;


                    			current = this_ParameterBoolean_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRos2Parser.g:3240:3: this_ParameterList_5= ruleParameterList
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterList_5=ruleParameterList();

                    state._fsp--;


                    			current = this_ParameterList_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRos2Parser.g:3249:3: this_ParameterStruct_6= ruleParameterStruct
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStruct_6=ruleParameterStruct();

                    state._fsp--;


                    			current = this_ParameterStruct_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterValue"


    // $ANTLR start "entryRuleParameterListType"
    // InternalRos2Parser.g:3261:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRos2Parser.g:3261:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRos2Parser.g:3262:2: iv_ruleParameterListType= ruleParameterListType EOF
            {
             newCompositeNode(grammarAccess.getParameterListTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterListType=ruleParameterListType();

            state._fsp--;

             current =iv_ruleParameterListType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterListType"


    // $ANTLR start "ruleParameterListType"
    // InternalRos2Parser.g:3268:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_sequence_3_0 = null;

        EObject lv_sequence_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3274:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos2Parser.g:3275:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos2Parser.g:3275:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos2Parser.g:3276:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos2Parser.g:3276:3: ()
            // InternalRos2Parser.g:3277:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos2Parser.g:3291:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRos2Parser.g:3292:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRos2Parser.g:3292:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRos2Parser.g:3293:5: lv_sequence_3_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_sequence_3_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
            					}
            					add(
            						current,
            						"sequence",
            						lv_sequence_3_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:3310:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==Comma) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalRos2Parser.g:3311:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_26); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos2Parser.g:3315:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRos2Parser.g:3316:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRos2Parser.g:3316:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRos2Parser.g:3317:6: lv_sequence_5_0= ruleParameterType
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_sequence_5_0=ruleParameterType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"sequence",
            	    							lv_sequence_5_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ParameterType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterListType"


    // $ANTLR start "entryRuleParameterStructType"
    // InternalRos2Parser.g:3343:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRos2Parser.g:3343:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRos2Parser.g:3344:2: iv_ruleParameterStructType= ruleParameterStructType EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructType=ruleParameterStructType();

            state._fsp--;

             current =iv_ruleParameterStructType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructType"


    // $ANTLR start "ruleParameterStructType"
    // InternalRos2Parser.g:3350:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterStructType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterstructypetmember_3_0 = null;

        EObject lv_parameterstructypetmember_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3356:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos2Parser.g:3357:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos2Parser.g:3357:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos2Parser.g:3358:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos2Parser.g:3358:3: ()
            // InternalRos2Parser.g:3359:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos2Parser.g:3373:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRos2Parser.g:3374:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRos2Parser.g:3374:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRos2Parser.g:3375:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_parameterstructypetmember_3_0=ruleParameterStructTypeMember();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
            					}
            					add(
            						current,
            						"parameterstructypetmember",
            						lv_parameterstructypetmember_3_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:3392:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==Comma) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalRos2Parser.g:3393:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos2Parser.g:3397:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRos2Parser.g:3398:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRos2Parser.g:3398:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRos2Parser.g:3399:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
            	    {

            	    						newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_parameterstructypetmember_5_0=ruleParameterStructTypeMember();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameterstructypetmember",
            	    							lv_parameterstructypetmember_5_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructType"


    // $ANTLR start "entryRuleParameterIntegerType"
    // InternalRos2Parser.g:3425:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRos2Parser.g:3425:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRos2Parser.g:3426:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterIntegerType=ruleParameterIntegerType();

            state._fsp--;

             current =iv_ruleParameterIntegerType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterIntegerType"


    // $ANTLR start "ruleParameterIntegerType"
    // InternalRos2Parser.g:3432:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3438:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRos2Parser.g:3439:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRos2Parser.g:3439:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRos2Parser.g:3440:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRos2Parser.g:3440:3: ()
            // InternalRos2Parser.g:3441:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRos2Parser.g:3451:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Default) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRos2Parser.g:3452:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3456:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRos2Parser.g:3457:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRos2Parser.g:3457:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRos2Parser.g:3458:6: lv_default_3_0= ruleParameterInteger
                    {

                    						newCompositeNode(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterIntegerTypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterIntegerType"


    // $ANTLR start "entryRuleParameterStringType"
    // InternalRos2Parser.g:3480:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRos2Parser.g:3480:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRos2Parser.g:3481:2: iv_ruleParameterStringType= ruleParameterStringType EOF
            {
             newCompositeNode(grammarAccess.getParameterStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStringType=ruleParameterStringType();

            state._fsp--;

             current =iv_ruleParameterStringType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStringType"


    // $ANTLR start "ruleParameterStringType"
    // InternalRos2Parser.g:3487:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3493:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRos2Parser.g:3494:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRos2Parser.g:3494:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRos2Parser.g:3495:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRos2Parser.g:3495:3: ()
            // InternalRos2Parser.g:3496:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRos2Parser.g:3506:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Default) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRos2Parser.g:3507:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3511:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRos2Parser.g:3512:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRos2Parser.g:3512:5: (lv_default_3_0= ruleParameterString )
                    // InternalRos2Parser.g:3513:6: lv_default_3_0= ruleParameterString
                    {

                    						newCompositeNode(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterStringTypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStringType"


    // $ANTLR start "entryRuleParameterDoubleType"
    // InternalRos2Parser.g:3535:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRos2Parser.g:3535:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRos2Parser.g:3536:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDoubleType=ruleParameterDoubleType();

            state._fsp--;

             current =iv_ruleParameterDoubleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDoubleType"


    // $ANTLR start "ruleParameterDoubleType"
    // InternalRos2Parser.g:3542:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3548:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRos2Parser.g:3549:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRos2Parser.g:3549:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRos2Parser.g:3550:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRos2Parser.g:3550:3: ()
            // InternalRos2Parser.g:3551:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRos2Parser.g:3561:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Default) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRos2Parser.g:3562:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3566:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRos2Parser.g:3567:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRos2Parser.g:3567:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRos2Parser.g:3568:6: lv_default_3_0= ruleParameterDouble
                    {

                    						newCompositeNode(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterDoubleTypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDoubleType"


    // $ANTLR start "entryRuleParameterBooleanType"
    // InternalRos2Parser.g:3590:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRos2Parser.g:3590:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRos2Parser.g:3591:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBooleanType=ruleParameterBooleanType();

            state._fsp--;

             current =iv_ruleParameterBooleanType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBooleanType"


    // $ANTLR start "ruleParameterBooleanType"
    // InternalRos2Parser.g:3597:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3603:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRos2Parser.g:3604:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRos2Parser.g:3604:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRos2Parser.g:3605:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRos2Parser.g:3605:3: ()
            // InternalRos2Parser.g:3606:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRos2Parser.g:3616:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==Default) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRos2Parser.g:3617:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3621:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRos2Parser.g:3622:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRos2Parser.g:3622:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRos2Parser.g:3623:6: lv_default_3_0= ruleParameterBoolean
                    {

                    						newCompositeNode(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterBooleanTypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBooleanType"


    // $ANTLR start "entryRuleParameterBase64Type"
    // InternalRos2Parser.g:3645:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRos2Parser.g:3645:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRos2Parser.g:3646:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64TypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64Type=ruleParameterBase64Type();

            state._fsp--;

             current =iv_ruleParameterBase64Type; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64Type"


    // $ANTLR start "ruleParameterBase64Type"
    // InternalRos2Parser.g:3652:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3658:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRos2Parser.g:3659:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRos2Parser.g:3659:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRos2Parser.g:3660:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRos2Parser.g:3660:3: ()
            // InternalRos2Parser.g:3661:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRos2Parser.g:3671:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Default) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRos2Parser.g:3672:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3676:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRos2Parser.g:3677:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRos2Parser.g:3677:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRos2Parser.g:3678:6: lv_default_3_0= ruleParameterBase64
                    {

                    						newCompositeNode(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBase64();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterBase64TypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterBase64");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64Type"


    // $ANTLR start "entryRuleParameterArrayType"
    // InternalRos2Parser.g:3700:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRos2Parser.g:3700:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRos2Parser.g:3701:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
            {
             newCompositeNode(grammarAccess.getParameterArrayTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterArrayType=ruleParameterArrayType();

            state._fsp--;

             current =iv_ruleParameterArrayType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterArrayType"


    // $ANTLR start "ruleParameterArrayType"
    // InternalRos2Parser.g:3707:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
    public final EObject ruleParameterArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_type_2_0 = null;

        EObject lv_default_5_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3713:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRos2Parser.g:3714:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRos2Parser.g:3714:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRos2Parser.g:3715:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos2Parser.g:3723:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRos2Parser.g:3724:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRos2Parser.g:3724:4: (lv_type_2_0= ruleParameterType )
            // InternalRos2Parser.g:3725:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_56);
            lv_type_2_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRos2Parser.g:3746:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==Default) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRos2Parser.g:3747:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRos2Parser.g:3751:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRos2Parser.g:3752:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRos2Parser.g:3752:5: (lv_default_5_0= ruleParameterList )
                    // InternalRos2Parser.g:3753:6: lv_default_5_0= ruleParameterList
                    {

                    						newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_5_0=ruleParameterList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_5_0,
                    							"de.fraunhofer.ipa.ros.Basics.ParameterList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterArrayType"


    // $ANTLR start "entryRuleParameterList"
    // InternalRos2Parser.g:3775:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRos2Parser.g:3775:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRos2Parser.g:3776:2: iv_ruleParameterList= ruleParameterList EOF
            {
             newCompositeNode(grammarAccess.getParameterListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;

             current =iv_ruleParameterList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalRos2Parser.g:3782:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3788:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRos2Parser.g:3789:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRos2Parser.g:3789:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRos2Parser.g:3790:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRos2Parser.g:3790:3: ()
            // InternalRos2Parser.g:3791:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos2Parser.g:3801:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos2Parser.g:3802:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos2Parser.g:3802:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos2Parser.g:3803:5: lv_value_2_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterListRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:3820:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==Comma) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalRos2Parser.g:3821:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_29); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRos2Parser.g:3825:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRos2Parser.g:3826:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRos2Parser.g:3826:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRos2Parser.g:3827:6: lv_value_4_0= ruleParameterValue
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_value_4_0=ruleParameterValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"value",
            	    							lv_value_4_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ParameterValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameterAny"
    // InternalRos2Parser.g:3853:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRos2Parser.g:3853:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRos2Parser.g:3854:2: iv_ruleParameterAny= ruleParameterAny EOF
            {
             newCompositeNode(grammarAccess.getParameterAnyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterAny=ruleParameterAny();

            state._fsp--;

             current =iv_ruleParameterAny; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterAny"


    // $ANTLR start "ruleParameterAny"
    // InternalRos2Parser.g:3860:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3866:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRos2Parser.g:3867:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRos2Parser.g:3867:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRos2Parser.g:3868:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRos2Parser.g:3868:3: ()
            // InternalRos2Parser.g:3869:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRos2Parser.g:3879:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Value) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRos2Parser.g:3880:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRos2Parser.g:3884:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRos2Parser.g:3885:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRos2Parser.g:3885:5: (lv_value_3_0= ruleEString )
                    // InternalRos2Parser.g:3886:6: lv_value_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterAnyRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"de.fraunhofer.ipa.ros.Basics.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterAny"


    // $ANTLR start "entryRuleParameterString"
    // InternalRos2Parser.g:3908:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRos2Parser.g:3908:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRos2Parser.g:3909:2: iv_ruleParameterString= ruleParameterString EOF
            {
             newCompositeNode(grammarAccess.getParameterStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterString=ruleParameterString();

            state._fsp--;

             current =iv_ruleParameterString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterString"


    // $ANTLR start "ruleParameterString"
    // InternalRos2Parser.g:3915:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3921:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRos2Parser.g:3922:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRos2Parser.g:3922:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRos2Parser.g:3923:3: (lv_value_0_0= ruleEString )
            {
            // InternalRos2Parser.g:3923:3: (lv_value_0_0= ruleEString )
            // InternalRos2Parser.g:3924:4: lv_value_0_0= ruleEString
            {

            				newCompositeNode(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEString();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterStringRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.EString");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterString"


    // $ANTLR start "entryRuleParameterBase64"
    // InternalRos2Parser.g:3944:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRos2Parser.g:3944:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRos2Parser.g:3945:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64=ruleParameterBase64();

            state._fsp--;

             current =iv_ruleParameterBase64; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64"


    // $ANTLR start "ruleParameterBase64"
    // InternalRos2Parser.g:3951:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3957:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRos2Parser.g:3958:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRos2Parser.g:3958:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRos2Parser.g:3959:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRos2Parser.g:3959:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRos2Parser.g:3960:4: lv_value_0_0= ruleBase64Binary
            {

            				newCompositeNode(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleBase64Binary();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterBase64Rule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.Base64Binary");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64"


    // $ANTLR start "entryRuleParameterInteger"
    // InternalRos2Parser.g:3980:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRos2Parser.g:3980:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRos2Parser.g:3981:2: iv_ruleParameterInteger= ruleParameterInteger EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterInteger=ruleParameterInteger();

            state._fsp--;

             current =iv_ruleParameterInteger; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterInteger"


    // $ANTLR start "ruleParameterInteger"
    // InternalRos2Parser.g:3987:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:3993:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRos2Parser.g:3994:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRos2Parser.g:3994:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRos2Parser.g:3995:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRos2Parser.g:3995:3: (lv_value_0_0= ruleInteger0 )
            // InternalRos2Parser.g:3996:4: lv_value_0_0= ruleInteger0
            {

            				newCompositeNode(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleInteger0();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterIntegerRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.Integer0");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterInteger"


    // $ANTLR start "entryRuleParameterDouble"
    // InternalRos2Parser.g:4016:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRos2Parser.g:4016:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRos2Parser.g:4017:2: iv_ruleParameterDouble= ruleParameterDouble EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDouble=ruleParameterDouble();

            state._fsp--;

             current =iv_ruleParameterDouble; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDouble"


    // $ANTLR start "ruleParameterDouble"
    // InternalRos2Parser.g:4023:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4029:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRos2Parser.g:4030:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRos2Parser.g:4030:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRos2Parser.g:4031:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRos2Parser.g:4031:3: (lv_value_0_0= ruleDouble0 )
            // InternalRos2Parser.g:4032:4: lv_value_0_0= ruleDouble0
            {

            				newCompositeNode(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDouble0();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterDoubleRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.Double0");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDouble"


    // $ANTLR start "entryRuleParameterBoolean"
    // InternalRos2Parser.g:4052:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRos2Parser.g:4052:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRos2Parser.g:4053:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBoolean=ruleParameterBoolean();

            state._fsp--;

             current =iv_ruleParameterBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBoolean"


    // $ANTLR start "ruleParameterBoolean"
    // InternalRos2Parser.g:4059:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4065:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRos2Parser.g:4066:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRos2Parser.g:4066:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRos2Parser.g:4067:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRos2Parser.g:4067:3: (lv_value_0_0= ruleboolean0 )
            // InternalRos2Parser.g:4068:4: lv_value_0_0= ruleboolean0
            {

            				newCompositeNode(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleboolean0();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterBooleanRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.boolean0");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBoolean"


    // $ANTLR start "entryRuleParameterStruct"
    // InternalRos2Parser.g:4088:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRos2Parser.g:4088:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRos2Parser.g:4089:2: iv_ruleParameterStruct= ruleParameterStruct EOF
            {
             newCompositeNode(grammarAccess.getParameterStructRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStruct=ruleParameterStruct();

            state._fsp--;

             current =iv_ruleParameterStruct; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStruct"


    // $ANTLR start "ruleParameterStruct"
    // InternalRos2Parser.g:4095:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4101:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRos2Parser.g:4102:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRos2Parser.g:4102:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRos2Parser.g:4103:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRos2Parser.g:4103:3: ()
            // InternalRos2Parser.g:4104:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRos2Parser.g:4110:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==LeftSquareBracket) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRos2Parser.g:4111:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_58); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRos2Parser.g:4119:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_STRING)) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalRos2Parser.g:4120:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRos2Parser.g:4120:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRos2Parser.g:4121:6: lv_value_3_0= ruleParameterStructMember
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_58);
                    	    lv_value_3_0=ruleParameterStructMember();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getParameterStructRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"value",
                    	    							lv_value_3_0,
                    	    							"de.fraunhofer.ipa.ros.Basics.ParameterStructMember");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3());
                    			
                    this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

                    				newLeafNode(this_END_5, grammarAccess.getParameterStructAccess().getENDTerminalRuleCall_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStruct"


    // $ANTLR start "entryRuleParameterDate"
    // InternalRos2Parser.g:4151:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRos2Parser.g:4151:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRos2Parser.g:4152:2: iv_ruleParameterDate= ruleParameterDate EOF
            {
             newCompositeNode(grammarAccess.getParameterDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDate=ruleParameterDate();

            state._fsp--;

             current =iv_ruleParameterDate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDate"


    // $ANTLR start "ruleParameterDate"
    // InternalRos2Parser.g:4158:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4164:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRos2Parser.g:4165:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRos2Parser.g:4165:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRos2Parser.g:4166:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRos2Parser.g:4166:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRos2Parser.g:4167:4: lv_value_0_0= ruleDateTime0
            {

            				newCompositeNode(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDateTime0();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterDateRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Basics.DateTime0");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDate"


    // $ANTLR start "entryRuleParameterStructMember"
    // InternalRos2Parser.g:4187:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRos2Parser.g:4187:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRos2Parser.g:4188:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructMember=ruleParameterStructMember();

            state._fsp--;

             current =iv_ruleParameterStructMember; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructMember"


    // $ANTLR start "ruleParameterStructMember"
    // InternalRos2Parser.g:4194:1: ruleParameterStructMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4200:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) )
            // InternalRos2Parser.g:4201:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            {
            // InternalRos2Parser.g:4201:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            // InternalRos2Parser.g:4202:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) )
            {
            // InternalRos2Parser.g:4202:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos2Parser.g:4203:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos2Parser.g:4203:4: (lv_name_0_0= ruleEString )
            // InternalRos2Parser.g:4204:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_1());
            		
            // InternalRos2Parser.g:4225:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos2Parser.g:4226:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos2Parser.g:4226:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos2Parser.g:4227:5: lv_value_2_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructMember"


    // $ANTLR start "entryRuleParameterStructTypeMember"
    // InternalRos2Parser.g:4248:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRos2Parser.g:4248:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRos2Parser.g:4249:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructTypeMember=ruleParameterStructTypeMember();

            state._fsp--;

             current =iv_ruleParameterStructTypeMember; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructTypeMember"


    // $ANTLR start "ruleParameterStructTypeMember"
    // InternalRos2Parser.g:4255:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4261:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRos2Parser.g:4262:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRos2Parser.g:4262:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRos2Parser.g:4263:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRos2Parser.g:4263:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos2Parser.g:4264:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos2Parser.g:4264:4: (lv_name_0_0= ruleEString )
            // InternalRos2Parser.g:4265:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.fraunhofer.ipa.ros.Basics.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:4282:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRos2Parser.g:4283:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRos2Parser.g:4283:4: (lv_type_1_0= ruleParameterType )
            // InternalRos2Parser.g:4284:5: lv_type_1_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"de.fraunhofer.ipa.ros.Basics.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructTypeMember"


    // $ANTLR start "entryRuleBase64Binary"
    // InternalRos2Parser.g:4305:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRos2Parser.g:4305:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRos2Parser.g:4306:2: iv_ruleBase64Binary= ruleBase64Binary EOF
            {
             newCompositeNode(grammarAccess.getBase64BinaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBase64Binary=ruleBase64Binary();

            state._fsp--;

             current =iv_ruleBase64Binary.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBase64Binary"


    // $ANTLR start "ruleBase64Binary"
    // InternalRos2Parser.g:4312:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4318:2: (this_BINARY_0= RULE_BINARY )
            // InternalRos2Parser.g:4319:2: this_BINARY_0= RULE_BINARY
            {
            this_BINARY_0=(Token)match(input,RULE_BINARY,FOLLOW_2); 

            		current.merge(this_BINARY_0);
            	

            		newLeafNode(this_BINARY_0, grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBase64Binary"


    // $ANTLR start "entryRuleboolean0"
    // InternalRos2Parser.g:4329:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRos2Parser.g:4329:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRos2Parser.g:4330:2: iv_ruleboolean0= ruleboolean0 EOF
            {
             newCompositeNode(grammarAccess.getBoolean0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleboolean0=ruleboolean0();

            state._fsp--;

             current =iv_ruleboolean0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolean0"


    // $ANTLR start "ruleboolean0"
    // InternalRos2Parser.g:4336:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4342:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRos2Parser.g:4343:2: this_BOOLEAN_0= RULE_BOOLEAN
            {
            this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            		current.merge(this_BOOLEAN_0);
            	

            		newLeafNode(this_BOOLEAN_0, grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolean0"


    // $ANTLR start "entryRuleDouble0"
    // InternalRos2Parser.g:4353:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRos2Parser.g:4353:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRos2Parser.g:4354:2: iv_ruleDouble0= ruleDouble0 EOF
            {
             newCompositeNode(grammarAccess.getDouble0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble0=ruleDouble0();

            state._fsp--;

             current =iv_ruleDouble0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble0"


    // $ANTLR start "ruleDouble0"
    // InternalRos2Parser.g:4360:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4366:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRos2Parser.g:4367:2: this_DOUBLE_0= RULE_DOUBLE
            {
            this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

            		current.merge(this_DOUBLE_0);
            	

            		newLeafNode(this_DOUBLE_0, grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble0"


    // $ANTLR start "entryRuleInteger0"
    // InternalRos2Parser.g:4377:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRos2Parser.g:4377:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRos2Parser.g:4378:2: iv_ruleInteger0= ruleInteger0 EOF
            {
             newCompositeNode(grammarAccess.getInteger0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteger0=ruleInteger0();

            state._fsp--;

             current =iv_ruleInteger0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger0"


    // $ANTLR start "ruleInteger0"
    // InternalRos2Parser.g:4384:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4390:2: (this_DECINT_0= RULE_DECINT )
            // InternalRos2Parser.g:4391:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2); 

            		current.merge(this_DECINT_0);
            	

            		newLeafNode(this_DECINT_0, grammarAccess.getInteger0Access().getDECINTTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger0"


    // $ANTLR start "entryRuleDateTime0"
    // InternalRos2Parser.g:4401:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRos2Parser.g:4401:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRos2Parser.g:4402:2: iv_ruleDateTime0= ruleDateTime0 EOF
            {
             newCompositeNode(grammarAccess.getDateTime0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateTime0=ruleDateTime0();

            state._fsp--;

             current =iv_ruleDateTime0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateTime0"


    // $ANTLR start "ruleDateTime0"
    // InternalRos2Parser.g:4408:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4414:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRos2Parser.g:4415:2: this_DATE_TIME_0= RULE_DATE_TIME
            {
            this_DATE_TIME_0=(Token)match(input,RULE_DATE_TIME,FOLLOW_2); 

            		current.merge(this_DATE_TIME_0);
            	

            		newLeafNode(this_DATE_TIME_0, grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateTime0"


    // $ANTLR start "entryRuleMessagePart"
    // InternalRos2Parser.g:4425:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRos2Parser.g:4425:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRos2Parser.g:4426:2: iv_ruleMessagePart= ruleMessagePart EOF
            {
             newCompositeNode(grammarAccess.getMessagePartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessagePart=ruleMessagePart();

            state._fsp--;

             current =iv_ruleMessagePart; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessagePart"


    // $ANTLR start "ruleMessagePart"
    // InternalRos2Parser.g:4432:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4438:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRos2Parser.g:4439:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRos2Parser.g:4439:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRos2Parser.g:4440:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRos2Parser.g:4440:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRos2Parser.g:4441:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRos2Parser.g:4441:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRos2Parser.g:4442:5: lv_Type_0_0= ruleAbstractType
            {

            					newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_59);
            lv_Type_0_0=ruleAbstractType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMessagePartRule());
            					}
            					set(
            						current,
            						"Type",
            						lv_Type_0_0,
            						"de.fraunhofer.ipa.ros.Basics.AbstractType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos2Parser.g:4459:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRos2Parser.g:4460:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRos2Parser.g:4460:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRos2Parser.g:4461:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRos2Parser.g:4461:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt76=3;
            switch ( input.LA(1) ) {
            case Duration:
            case Feedback:
            case Message:
            case Service:
            case Action:
            case Result:
            case Value:
            case Goal:
            case Name:
            case Time:
            case Type:
                {
                alt76=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt76=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
                {
                alt76=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalRos2Parser.g:4462:6: lv_Data_1_1= ruleKEYWORD
                    {

                    						newCompositeNode(grammarAccess.getMessagePartAccess().getDataKEYWORDParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_Data_1_1=ruleKEYWORD();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessagePartRule());
                    						}
                    						set(
                    							current,
                    							"Data",
                    							lv_Data_1_1,
                    							"de.fraunhofer.ipa.ros.Basics.KEYWORD");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:4478:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
                    {
                    lv_Data_1_2=(Token)match(input,RULE_MESSAGE_ASIGMENT,FOLLOW_2); 

                    						newLeafNode(lv_Data_1_2, grammarAccess.getMessagePartAccess().getDataMESSAGE_ASIGMENTTerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMessagePartRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"Data",
                    							lv_Data_1_2,
                    							"de.fraunhofer.ipa.ros.Basics.MESSAGE_ASIGMENT");
                    					

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:4493:6: lv_Data_1_3= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMessagePartAccess().getDataEStringParserRuleCall_1_0_2());
                    					
                    pushFollow(FOLLOW_2);
                    lv_Data_1_3=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessagePartRule());
                    						}
                    						set(
                    							current,
                    							"Data",
                    							lv_Data_1_3,
                    							"de.fraunhofer.ipa.ros.Basics.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessagePart"


    // $ANTLR start "entryRuleAbstractType"
    // InternalRos2Parser.g:4515:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRos2Parser.g:4515:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRos2Parser.g:4516:2: iv_ruleAbstractType= ruleAbstractType EOF
            {
             newCompositeNode(grammarAccess.getAbstractTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractType=ruleAbstractType();

            state._fsp--;

             current =iv_ruleAbstractType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractType"


    // $ANTLR start "ruleAbstractType"
    // InternalRos2Parser.g:4522:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
    public final EObject ruleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject this_bool_0 = null;

        EObject this_int8_1 = null;

        EObject this_uint8_2 = null;

        EObject this_int16_3 = null;

        EObject this_uint16_4 = null;

        EObject this_int32_5 = null;

        EObject this_uint32_6 = null;

        EObject this_int64_7 = null;

        EObject this_uint64_8 = null;

        EObject this_float32_9 = null;

        EObject this_float64_10 = null;

        EObject this_string0_11 = null;

        EObject this_byte_12 = null;

        EObject this_time_13 = null;

        EObject this_duration_14 = null;

        EObject this_Header_15 = null;

        EObject this_boolArray_16 = null;

        EObject this_int8Array_17 = null;

        EObject this_uint8Array_18 = null;

        EObject this_int16Array_19 = null;

        EObject this_uint16Array_20 = null;

        EObject this_int32Array_21 = null;

        EObject this_uint32Array_22 = null;

        EObject this_int64Array_23 = null;

        EObject this_uint64Array_24 = null;

        EObject this_float32Array_25 = null;

        EObject this_float64Array_26 = null;

        EObject this_string0Array_27 = null;

        EObject this_byteArray_28 = null;

        EObject this_SpecBaseRef_29 = null;

        EObject this_ArraySpecRef_30 = null;

        EObject this_char_31 = null;

        EObject this_charArray_32 = null;



        	enterRule();

        try {
            // InternalRos2Parser.g:4528:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRos2Parser.g:4529:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRos2Parser.g:4529:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt77=33;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalRos2Parser.g:4530:3: this_bool_0= rulebool
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;


                    			current = this_bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:4539:3: this_int8_1= ruleint8
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;


                    			current = this_int8_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:4548:3: this_uint8_2= ruleuint8
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;


                    			current = this_uint8_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRos2Parser.g:4557:3: this_int16_3= ruleint16
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;


                    			current = this_int16_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRos2Parser.g:4566:3: this_uint16_4= ruleuint16
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;


                    			current = this_uint16_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRos2Parser.g:4575:3: this_int32_5= ruleint32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;


                    			current = this_int32_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRos2Parser.g:4584:3: this_uint32_6= ruleuint32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;


                    			current = this_uint32_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRos2Parser.g:4593:3: this_int64_7= ruleint64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;


                    			current = this_int64_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRos2Parser.g:4602:3: this_uint64_8= ruleuint64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;


                    			current = this_uint64_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRos2Parser.g:4611:3: this_float32_9= rulefloat32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;


                    			current = this_float32_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRos2Parser.g:4620:3: this_float64_10= rulefloat64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;


                    			current = this_float64_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRos2Parser.g:4629:3: this_string0_11= rulestring0
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;


                    			current = this_string0_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRos2Parser.g:4638:3: this_byte_12= rulebyte
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;


                    			current = this_byte_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalRos2Parser.g:4647:3: this_time_13= ruletime
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;


                    			current = this_time_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalRos2Parser.g:4656:3: this_duration_14= ruleduration
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;


                    			current = this_duration_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalRos2Parser.g:4665:3: this_Header_15= ruleHeader
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;


                    			current = this_Header_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalRos2Parser.g:4674:3: this_boolArray_16= ruleboolArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_boolArray_16=ruleboolArray();

                    state._fsp--;


                    			current = this_boolArray_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalRos2Parser.g:4683:3: this_int8Array_17= ruleint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8Array_17=ruleint8Array();

                    state._fsp--;


                    			current = this_int8Array_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 19 :
                    // InternalRos2Parser.g:4692:3: this_uint8Array_18= ruleuint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8Array_18=ruleuint8Array();

                    state._fsp--;


                    			current = this_uint8Array_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 20 :
                    // InternalRos2Parser.g:4701:3: this_int16Array_19= ruleint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16Array_19=ruleint16Array();

                    state._fsp--;


                    			current = this_int16Array_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 21 :
                    // InternalRos2Parser.g:4710:3: this_uint16Array_20= ruleuint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16Array_20=ruleuint16Array();

                    state._fsp--;


                    			current = this_uint16Array_20;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 22 :
                    // InternalRos2Parser.g:4719:3: this_int32Array_21= ruleint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32Array_21=ruleint32Array();

                    state._fsp--;


                    			current = this_int32Array_21;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 23 :
                    // InternalRos2Parser.g:4728:3: this_uint32Array_22= ruleuint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32Array_22=ruleuint32Array();

                    state._fsp--;


                    			current = this_uint32Array_22;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 24 :
                    // InternalRos2Parser.g:4737:3: this_int64Array_23= ruleint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64Array_23=ruleint64Array();

                    state._fsp--;


                    			current = this_int64Array_23;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 25 :
                    // InternalRos2Parser.g:4746:3: this_uint64Array_24= ruleuint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64Array_24=ruleuint64Array();

                    state._fsp--;


                    			current = this_uint64Array_24;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 26 :
                    // InternalRos2Parser.g:4755:3: this_float32Array_25= rulefloat32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32Array_25=rulefloat32Array();

                    state._fsp--;


                    			current = this_float32Array_25;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 27 :
                    // InternalRos2Parser.g:4764:3: this_float64Array_26= rulefloat64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64Array_26=rulefloat64Array();

                    state._fsp--;


                    			current = this_float64Array_26;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 28 :
                    // InternalRos2Parser.g:4773:3: this_string0Array_27= rulestring0Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0Array_27=rulestring0Array();

                    state._fsp--;


                    			current = this_string0Array_27;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 29 :
                    // InternalRos2Parser.g:4782:3: this_byteArray_28= rulebyteArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28());
                    		
                    pushFollow(FOLLOW_2);
                    this_byteArray_28=rulebyteArray();

                    state._fsp--;


                    			current = this_byteArray_28;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 30 :
                    // InternalRos2Parser.g:4791:3: this_SpecBaseRef_29= ruleSpecBaseRef
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getSpecBaseRefParserRuleCall_29());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecBaseRef_29=ruleSpecBaseRef();

                    state._fsp--;


                    			current = this_SpecBaseRef_29;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 31 :
                    // InternalRos2Parser.g:4800:3: this_ArraySpecRef_30= ruleArraySpecRef
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_30());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArraySpecRef_30=ruleArraySpecRef();

                    state._fsp--;


                    			current = this_ArraySpecRef_30;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 32 :
                    // InternalRos2Parser.g:4809:3: this_char_31= rulechar
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharParserRuleCall_31());
                    		
                    pushFollow(FOLLOW_2);
                    this_char_31=rulechar();

                    state._fsp--;


                    			current = this_char_31;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 33 :
                    // InternalRos2Parser.g:4818:3: this_charArray_32= rulecharArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_32());
                    		
                    pushFollow(FOLLOW_2);
                    this_charArray_32=rulecharArray();

                    state._fsp--;


                    			current = this_charArray_32;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractType"


    // $ANTLR start "entryRulebool"
    // InternalRos2Parser.g:4830:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRos2Parser.g:4830:45: (iv_rulebool= rulebool EOF )
            // InternalRos2Parser.g:4831:2: iv_rulebool= rulebool EOF
            {
             newCompositeNode(grammarAccess.getBoolRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebool=rulebool();

            state._fsp--;

             current =iv_rulebool; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebool"


    // $ANTLR start "rulebool"
    // InternalRos2Parser.g:4837:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4843:2: ( ( () otherlv_1= Bool ) )
            // InternalRos2Parser.g:4844:2: ( () otherlv_1= Bool )
            {
            // InternalRos2Parser.g:4844:2: ( () otherlv_1= Bool )
            // InternalRos2Parser.g:4845:3: () otherlv_1= Bool
            {
            // InternalRos2Parser.g:4845:3: ()
            // InternalRos2Parser.g:4846:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolAccess().getBoolAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebool"


    // $ANTLR start "entryRuleint8"
    // InternalRos2Parser.g:4860:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRos2Parser.g:4860:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRos2Parser.g:4861:2: iv_ruleint8= ruleint8 EOF
            {
             newCompositeNode(grammarAccess.getInt8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint8=ruleint8();

            state._fsp--;

             current =iv_ruleint8; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8"


    // $ANTLR start "ruleint8"
    // InternalRos2Parser.g:4867:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4873:2: ( ( () otherlv_1= Int8 ) )
            // InternalRos2Parser.g:4874:2: ( () otherlv_1= Int8 )
            {
            // InternalRos2Parser.g:4874:2: ( () otherlv_1= Int8 )
            // InternalRos2Parser.g:4875:3: () otherlv_1= Int8
            {
            // InternalRos2Parser.g:4875:3: ()
            // InternalRos2Parser.g:4876:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8Access().getInt8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt8Access().getInt8Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8"


    // $ANTLR start "entryRuleuint8"
    // InternalRos2Parser.g:4890:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRos2Parser.g:4890:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRos2Parser.g:4891:2: iv_ruleuint8= ruleuint8 EOF
            {
             newCompositeNode(grammarAccess.getUint8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint8=ruleuint8();

            state._fsp--;

             current =iv_ruleuint8; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8"


    // $ANTLR start "ruleuint8"
    // InternalRos2Parser.g:4897:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4903:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRos2Parser.g:4904:2: ( () otherlv_1= Uint8 )
            {
            // InternalRos2Parser.g:4904:2: ( () otherlv_1= Uint8 )
            // InternalRos2Parser.g:4905:3: () otherlv_1= Uint8
            {
            // InternalRos2Parser.g:4905:3: ()
            // InternalRos2Parser.g:4906:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8Access().getUint8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint8Access().getUint8Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8"


    // $ANTLR start "entryRuleint16"
    // InternalRos2Parser.g:4920:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRos2Parser.g:4920:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRos2Parser.g:4921:2: iv_ruleint16= ruleint16 EOF
            {
             newCompositeNode(grammarAccess.getInt16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint16=ruleint16();

            state._fsp--;

             current =iv_ruleint16; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16"


    // $ANTLR start "ruleint16"
    // InternalRos2Parser.g:4927:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4933:2: ( ( () otherlv_1= Int16 ) )
            // InternalRos2Parser.g:4934:2: ( () otherlv_1= Int16 )
            {
            // InternalRos2Parser.g:4934:2: ( () otherlv_1= Int16 )
            // InternalRos2Parser.g:4935:3: () otherlv_1= Int16
            {
            // InternalRos2Parser.g:4935:3: ()
            // InternalRos2Parser.g:4936:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16Access().getInt16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt16Access().getInt16Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16"


    // $ANTLR start "entryRuleuint16"
    // InternalRos2Parser.g:4950:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRos2Parser.g:4950:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRos2Parser.g:4951:2: iv_ruleuint16= ruleuint16 EOF
            {
             newCompositeNode(grammarAccess.getUint16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint16=ruleuint16();

            state._fsp--;

             current =iv_ruleuint16; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16"


    // $ANTLR start "ruleuint16"
    // InternalRos2Parser.g:4957:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4963:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRos2Parser.g:4964:2: ( () otherlv_1= Uint16 )
            {
            // InternalRos2Parser.g:4964:2: ( () otherlv_1= Uint16 )
            // InternalRos2Parser.g:4965:3: () otherlv_1= Uint16
            {
            // InternalRos2Parser.g:4965:3: ()
            // InternalRos2Parser.g:4966:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16Access().getUint16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint16Access().getUint16Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16"


    // $ANTLR start "entryRuleint32"
    // InternalRos2Parser.g:4980:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRos2Parser.g:4980:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRos2Parser.g:4981:2: iv_ruleint32= ruleint32 EOF
            {
             newCompositeNode(grammarAccess.getInt32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint32=ruleint32();

            state._fsp--;

             current =iv_ruleint32; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32"


    // $ANTLR start "ruleint32"
    // InternalRos2Parser.g:4987:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:4993:2: ( ( () otherlv_1= Int32 ) )
            // InternalRos2Parser.g:4994:2: ( () otherlv_1= Int32 )
            {
            // InternalRos2Parser.g:4994:2: ( () otherlv_1= Int32 )
            // InternalRos2Parser.g:4995:3: () otherlv_1= Int32
            {
            // InternalRos2Parser.g:4995:3: ()
            // InternalRos2Parser.g:4996:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32Access().getInt32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt32Access().getInt32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32"


    // $ANTLR start "entryRuleuint32"
    // InternalRos2Parser.g:5010:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRos2Parser.g:5010:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRos2Parser.g:5011:2: iv_ruleuint32= ruleuint32 EOF
            {
             newCompositeNode(grammarAccess.getUint32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint32=ruleuint32();

            state._fsp--;

             current =iv_ruleuint32; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32"


    // $ANTLR start "ruleuint32"
    // InternalRos2Parser.g:5017:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5023:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRos2Parser.g:5024:2: ( () otherlv_1= Uint32 )
            {
            // InternalRos2Parser.g:5024:2: ( () otherlv_1= Uint32 )
            // InternalRos2Parser.g:5025:3: () otherlv_1= Uint32
            {
            // InternalRos2Parser.g:5025:3: ()
            // InternalRos2Parser.g:5026:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32Access().getUint32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint32Access().getUint32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32"


    // $ANTLR start "entryRuleint64"
    // InternalRos2Parser.g:5040:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRos2Parser.g:5040:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRos2Parser.g:5041:2: iv_ruleint64= ruleint64 EOF
            {
             newCompositeNode(grammarAccess.getInt64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint64=ruleint64();

            state._fsp--;

             current =iv_ruleint64; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64"


    // $ANTLR start "ruleint64"
    // InternalRos2Parser.g:5047:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5053:2: ( ( () otherlv_1= Int64 ) )
            // InternalRos2Parser.g:5054:2: ( () otherlv_1= Int64 )
            {
            // InternalRos2Parser.g:5054:2: ( () otherlv_1= Int64 )
            // InternalRos2Parser.g:5055:3: () otherlv_1= Int64
            {
            // InternalRos2Parser.g:5055:3: ()
            // InternalRos2Parser.g:5056:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64Access().getInt64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt64Access().getInt64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64"


    // $ANTLR start "entryRuleuint64"
    // InternalRos2Parser.g:5070:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRos2Parser.g:5070:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRos2Parser.g:5071:2: iv_ruleuint64= ruleuint64 EOF
            {
             newCompositeNode(grammarAccess.getUint64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint64=ruleuint64();

            state._fsp--;

             current =iv_ruleuint64; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64"


    // $ANTLR start "ruleuint64"
    // InternalRos2Parser.g:5077:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5083:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRos2Parser.g:5084:2: ( () otherlv_1= Uint64 )
            {
            // InternalRos2Parser.g:5084:2: ( () otherlv_1= Uint64 )
            // InternalRos2Parser.g:5085:3: () otherlv_1= Uint64
            {
            // InternalRos2Parser.g:5085:3: ()
            // InternalRos2Parser.g:5086:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64Access().getUint64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint64Access().getUint64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64"


    // $ANTLR start "entryRulefloat32"
    // InternalRos2Parser.g:5100:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRos2Parser.g:5100:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRos2Parser.g:5101:2: iv_rulefloat32= rulefloat32 EOF
            {
             newCompositeNode(grammarAccess.getFloat32Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat32=rulefloat32();

            state._fsp--;

             current =iv_rulefloat32; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32"


    // $ANTLR start "rulefloat32"
    // InternalRos2Parser.g:5107:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5113:2: ( ( () otherlv_1= Float32 ) )
            // InternalRos2Parser.g:5114:2: ( () otherlv_1= Float32 )
            {
            // InternalRos2Parser.g:5114:2: ( () otherlv_1= Float32 )
            // InternalRos2Parser.g:5115:3: () otherlv_1= Float32
            {
            // InternalRos2Parser.g:5115:3: ()
            // InternalRos2Parser.g:5116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32Access().getFloat32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat32Access().getFloat32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32"


    // $ANTLR start "entryRulefloat64"
    // InternalRos2Parser.g:5130:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRos2Parser.g:5130:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRos2Parser.g:5131:2: iv_rulefloat64= rulefloat64 EOF
            {
             newCompositeNode(grammarAccess.getFloat64Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat64=rulefloat64();

            state._fsp--;

             current =iv_rulefloat64; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64"


    // $ANTLR start "rulefloat64"
    // InternalRos2Parser.g:5137:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5143:2: ( ( () otherlv_1= Float64 ) )
            // InternalRos2Parser.g:5144:2: ( () otherlv_1= Float64 )
            {
            // InternalRos2Parser.g:5144:2: ( () otherlv_1= Float64 )
            // InternalRos2Parser.g:5145:3: () otherlv_1= Float64
            {
            // InternalRos2Parser.g:5145:3: ()
            // InternalRos2Parser.g:5146:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64Access().getFloat64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat64Access().getFloat64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64"


    // $ANTLR start "entryRulestring0"
    // InternalRos2Parser.g:5160:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRos2Parser.g:5160:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRos2Parser.g:5161:2: iv_rulestring0= rulestring0 EOF
            {
             newCompositeNode(grammarAccess.getString0Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulestring0=rulestring0();

            state._fsp--;

             current =iv_rulestring0; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0"


    // $ANTLR start "rulestring0"
    // InternalRos2Parser.g:5167:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5173:2: ( ( () otherlv_1= String_1 ) )
            // InternalRos2Parser.g:5174:2: ( () otherlv_1= String_1 )
            {
            // InternalRos2Parser.g:5174:2: ( () otherlv_1= String_1 )
            // InternalRos2Parser.g:5175:3: () otherlv_1= String_1
            {
            // InternalRos2Parser.g:5175:3: ()
            // InternalRos2Parser.g:5176:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0Access().getStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getString0Access().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0"


    // $ANTLR start "entryRulechar"
    // InternalRos2Parser.g:5190:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRos2Parser.g:5190:45: (iv_rulechar= rulechar EOF )
            // InternalRos2Parser.g:5191:2: iv_rulechar= rulechar EOF
            {
             newCompositeNode(grammarAccess.getCharRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechar=rulechar();

            state._fsp--;

             current =iv_rulechar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechar"


    // $ANTLR start "rulechar"
    // InternalRos2Parser.g:5197:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5203:2: ( ( () otherlv_1= Char ) )
            // InternalRos2Parser.g:5204:2: ( () otherlv_1= Char )
            {
            // InternalRos2Parser.g:5204:2: ( () otherlv_1= Char )
            // InternalRos2Parser.g:5205:3: () otherlv_1= Char
            {
            // InternalRos2Parser.g:5205:3: ()
            // InternalRos2Parser.g:5206:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharAccess().getChar0Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCharAccess().getCharKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechar"


    // $ANTLR start "entryRulebyte"
    // InternalRos2Parser.g:5220:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRos2Parser.g:5220:45: (iv_rulebyte= rulebyte EOF )
            // InternalRos2Parser.g:5221:2: iv_rulebyte= rulebyte EOF
            {
             newCompositeNode(grammarAccess.getByteRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebyte=rulebyte();

            state._fsp--;

             current =iv_rulebyte; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyte"


    // $ANTLR start "rulebyte"
    // InternalRos2Parser.g:5227:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5233:2: ( ( () otherlv_1= Byte ) )
            // InternalRos2Parser.g:5234:2: ( () otherlv_1= Byte )
            {
            // InternalRos2Parser.g:5234:2: ( () otherlv_1= Byte )
            // InternalRos2Parser.g:5235:3: () otherlv_1= Byte
            {
            // InternalRos2Parser.g:5235:3: ()
            // InternalRos2Parser.g:5236:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteAccess().getByteAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getByteAccess().getByteKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyte"


    // $ANTLR start "entryRuletime"
    // InternalRos2Parser.g:5250:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRos2Parser.g:5250:45: (iv_ruletime= ruletime EOF )
            // InternalRos2Parser.g:5251:2: iv_ruletime= ruletime EOF
            {
             newCompositeNode(grammarAccess.getTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruletime=ruletime();

            state._fsp--;

             current =iv_ruletime; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletime"


    // $ANTLR start "ruletime"
    // InternalRos2Parser.g:5257:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5263:2: ( ( () otherlv_1= Time ) )
            // InternalRos2Parser.g:5264:2: ( () otherlv_1= Time )
            {
            // InternalRos2Parser.g:5264:2: ( () otherlv_1= Time )
            // InternalRos2Parser.g:5265:3: () otherlv_1= Time
            {
            // InternalRos2Parser.g:5265:3: ()
            // InternalRos2Parser.g:5266:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeAccess().getTimeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Time,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTimeKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletime"


    // $ANTLR start "entryRuleduration"
    // InternalRos2Parser.g:5280:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRos2Parser.g:5280:49: (iv_ruleduration= ruleduration EOF )
            // InternalRos2Parser.g:5281:2: iv_ruleduration= ruleduration EOF
            {
             newCompositeNode(grammarAccess.getDurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleduration=ruleduration();

            state._fsp--;

             current =iv_ruleduration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleduration"


    // $ANTLR start "ruleduration"
    // InternalRos2Parser.g:5287:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5293:2: ( ( () otherlv_1= Duration ) )
            // InternalRos2Parser.g:5294:2: ( () otherlv_1= Duration )
            {
            // InternalRos2Parser.g:5294:2: ( () otherlv_1= Duration )
            // InternalRos2Parser.g:5295:3: () otherlv_1= Duration
            {
            // InternalRos2Parser.g:5295:3: ()
            // InternalRos2Parser.g:5296:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDurationAccess().getDurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Duration,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDurationAccess().getDurationKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleduration"


    // $ANTLR start "entryRuleboolArray"
    // InternalRos2Parser.g:5310:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRos2Parser.g:5310:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRos2Parser.g:5311:2: iv_ruleboolArray= ruleboolArray EOF
            {
             newCompositeNode(grammarAccess.getBoolArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleboolArray=ruleboolArray();

            state._fsp--;

             current =iv_ruleboolArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolArray"


    // $ANTLR start "ruleboolArray"
    // InternalRos2Parser.g:5317:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5323:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRos2Parser.g:5324:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRos2Parser.g:5324:2: ( () otherlv_1= Bool_1 )
            // InternalRos2Parser.g:5325:3: () otherlv_1= Bool_1
            {
            // InternalRos2Parser.g:5325:3: ()
            // InternalRos2Parser.g:5326:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolArrayAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolArray"


    // $ANTLR start "entryRuleint8Array"
    // InternalRos2Parser.g:5340:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRos2Parser.g:5340:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRos2Parser.g:5341:2: iv_ruleint8Array= ruleint8Array EOF
            {
             newCompositeNode(grammarAccess.getInt8ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint8Array=ruleint8Array();

            state._fsp--;

             current =iv_ruleint8Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8Array"


    // $ANTLR start "ruleint8Array"
    // InternalRos2Parser.g:5347:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5353:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRos2Parser.g:5354:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRos2Parser.g:5354:2: ( () otherlv_1= Int8_1 )
            // InternalRos2Parser.g:5355:3: () otherlv_1= Int8_1
            {
            // InternalRos2Parser.g:5355:3: ()
            // InternalRos2Parser.g:5356:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt8ArrayAccess().getInt8Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8Array"


    // $ANTLR start "entryRuleuint8Array"
    // InternalRos2Parser.g:5370:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRos2Parser.g:5370:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRos2Parser.g:5371:2: iv_ruleuint8Array= ruleuint8Array EOF
            {
             newCompositeNode(grammarAccess.getUint8ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint8Array=ruleuint8Array();

            state._fsp--;

             current =iv_ruleuint8Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8Array"


    // $ANTLR start "ruleuint8Array"
    // InternalRos2Parser.g:5377:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5383:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRos2Parser.g:5384:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRos2Parser.g:5384:2: ( () otherlv_1= Uint8_1 )
            // InternalRos2Parser.g:5385:3: () otherlv_1= Uint8_1
            {
            // InternalRos2Parser.g:5385:3: ()
            // InternalRos2Parser.g:5386:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint8ArrayAccess().getUint8Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8Array"


    // $ANTLR start "entryRuleint16Array"
    // InternalRos2Parser.g:5400:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRos2Parser.g:5400:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRos2Parser.g:5401:2: iv_ruleint16Array= ruleint16Array EOF
            {
             newCompositeNode(grammarAccess.getInt16ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint16Array=ruleint16Array();

            state._fsp--;

             current =iv_ruleint16Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16Array"


    // $ANTLR start "ruleint16Array"
    // InternalRos2Parser.g:5407:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5413:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRos2Parser.g:5414:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRos2Parser.g:5414:2: ( () otherlv_1= Int16_1 )
            // InternalRos2Parser.g:5415:3: () otherlv_1= Int16_1
            {
            // InternalRos2Parser.g:5415:3: ()
            // InternalRos2Parser.g:5416:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt16ArrayAccess().getInt16Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16Array"


    // $ANTLR start "entryRuleuint16Array"
    // InternalRos2Parser.g:5430:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRos2Parser.g:5430:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRos2Parser.g:5431:2: iv_ruleuint16Array= ruleuint16Array EOF
            {
             newCompositeNode(grammarAccess.getUint16ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint16Array=ruleuint16Array();

            state._fsp--;

             current =iv_ruleuint16Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16Array"


    // $ANTLR start "ruleuint16Array"
    // InternalRos2Parser.g:5437:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5443:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRos2Parser.g:5444:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRos2Parser.g:5444:2: ( () otherlv_1= Uint16_1 )
            // InternalRos2Parser.g:5445:3: () otherlv_1= Uint16_1
            {
            // InternalRos2Parser.g:5445:3: ()
            // InternalRos2Parser.g:5446:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint16ArrayAccess().getUint16Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16Array"


    // $ANTLR start "entryRuleint32Array"
    // InternalRos2Parser.g:5460:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRos2Parser.g:5460:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRos2Parser.g:5461:2: iv_ruleint32Array= ruleint32Array EOF
            {
             newCompositeNode(grammarAccess.getInt32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint32Array=ruleint32Array();

            state._fsp--;

             current =iv_ruleint32Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32Array"


    // $ANTLR start "ruleint32Array"
    // InternalRos2Parser.g:5467:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5473:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRos2Parser.g:5474:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRos2Parser.g:5474:2: ( () otherlv_1= Int32_1 )
            // InternalRos2Parser.g:5475:3: () otherlv_1= Int32_1
            {
            // InternalRos2Parser.g:5475:3: ()
            // InternalRos2Parser.g:5476:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt32ArrayAccess().getInt32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32Array"


    // $ANTLR start "entryRuleuint32Array"
    // InternalRos2Parser.g:5490:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRos2Parser.g:5490:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRos2Parser.g:5491:2: iv_ruleuint32Array= ruleuint32Array EOF
            {
             newCompositeNode(grammarAccess.getUint32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint32Array=ruleuint32Array();

            state._fsp--;

             current =iv_ruleuint32Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32Array"


    // $ANTLR start "ruleuint32Array"
    // InternalRos2Parser.g:5497:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5503:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRos2Parser.g:5504:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRos2Parser.g:5504:2: ( () otherlv_1= Uint32_1 )
            // InternalRos2Parser.g:5505:3: () otherlv_1= Uint32_1
            {
            // InternalRos2Parser.g:5505:3: ()
            // InternalRos2Parser.g:5506:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint32ArrayAccess().getUint32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32Array"


    // $ANTLR start "entryRuleint64Array"
    // InternalRos2Parser.g:5520:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRos2Parser.g:5520:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRos2Parser.g:5521:2: iv_ruleint64Array= ruleint64Array EOF
            {
             newCompositeNode(grammarAccess.getInt64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint64Array=ruleint64Array();

            state._fsp--;

             current =iv_ruleint64Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64Array"


    // $ANTLR start "ruleint64Array"
    // InternalRos2Parser.g:5527:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5533:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRos2Parser.g:5534:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRos2Parser.g:5534:2: ( () otherlv_1= Int64_1 )
            // InternalRos2Parser.g:5535:3: () otherlv_1= Int64_1
            {
            // InternalRos2Parser.g:5535:3: ()
            // InternalRos2Parser.g:5536:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt64ArrayAccess().getInt64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64Array"


    // $ANTLR start "entryRuleuint64Array"
    // InternalRos2Parser.g:5550:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRos2Parser.g:5550:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRos2Parser.g:5551:2: iv_ruleuint64Array= ruleuint64Array EOF
            {
             newCompositeNode(grammarAccess.getUint64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint64Array=ruleuint64Array();

            state._fsp--;

             current =iv_ruleuint64Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64Array"


    // $ANTLR start "ruleuint64Array"
    // InternalRos2Parser.g:5557:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5563:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRos2Parser.g:5564:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRos2Parser.g:5564:2: ( () otherlv_1= Uint64_1 )
            // InternalRos2Parser.g:5565:3: () otherlv_1= Uint64_1
            {
            // InternalRos2Parser.g:5565:3: ()
            // InternalRos2Parser.g:5566:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint64ArrayAccess().getUint64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64Array"


    // $ANTLR start "entryRulefloat32Array"
    // InternalRos2Parser.g:5580:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRos2Parser.g:5580:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRos2Parser.g:5581:2: iv_rulefloat32Array= rulefloat32Array EOF
            {
             newCompositeNode(grammarAccess.getFloat32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat32Array=rulefloat32Array();

            state._fsp--;

             current =iv_rulefloat32Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32Array"


    // $ANTLR start "rulefloat32Array"
    // InternalRos2Parser.g:5587:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5593:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRos2Parser.g:5594:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRos2Parser.g:5594:2: ( () otherlv_1= Float32_1 )
            // InternalRos2Parser.g:5595:3: () otherlv_1= Float32_1
            {
            // InternalRos2Parser.g:5595:3: ()
            // InternalRos2Parser.g:5596:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32Array"


    // $ANTLR start "entryRulefloat64Array"
    // InternalRos2Parser.g:5610:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRos2Parser.g:5610:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRos2Parser.g:5611:2: iv_rulefloat64Array= rulefloat64Array EOF
            {
             newCompositeNode(grammarAccess.getFloat64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat64Array=rulefloat64Array();

            state._fsp--;

             current =iv_rulefloat64Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64Array"


    // $ANTLR start "rulefloat64Array"
    // InternalRos2Parser.g:5617:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5623:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRos2Parser.g:5624:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRos2Parser.g:5624:2: ( () otherlv_1= Float64_1 )
            // InternalRos2Parser.g:5625:3: () otherlv_1= Float64_1
            {
            // InternalRos2Parser.g:5625:3: ()
            // InternalRos2Parser.g:5626:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64Array"


    // $ANTLR start "entryRulestring0Array"
    // InternalRos2Parser.g:5640:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRos2Parser.g:5640:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRos2Parser.g:5641:2: iv_rulestring0Array= rulestring0Array EOF
            {
             newCompositeNode(grammarAccess.getString0ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulestring0Array=rulestring0Array();

            state._fsp--;

             current =iv_rulestring0Array; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0Array"


    // $ANTLR start "rulestring0Array"
    // InternalRos2Parser.g:5647:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5653:2: ( ( () otherlv_1= String_2 ) )
            // InternalRos2Parser.g:5654:2: ( () otherlv_1= String_2 )
            {
            // InternalRos2Parser.g:5654:2: ( () otherlv_1= String_2 )
            // InternalRos2Parser.g:5655:3: () otherlv_1= String_2
            {
            // InternalRos2Parser.g:5655:3: ()
            // InternalRos2Parser.g:5656:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getString0ArrayAccess().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0Array"


    // $ANTLR start "entryRulebyteArray"
    // InternalRos2Parser.g:5670:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRos2Parser.g:5670:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRos2Parser.g:5671:2: iv_rulebyteArray= rulebyteArray EOF
            {
             newCompositeNode(grammarAccess.getByteArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebyteArray=rulebyteArray();

            state._fsp--;

             current =iv_rulebyteArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyteArray"


    // $ANTLR start "rulebyteArray"
    // InternalRos2Parser.g:5677:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5683:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRos2Parser.g:5684:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRos2Parser.g:5684:2: ( () otherlv_1= Byte_1 )
            // InternalRos2Parser.g:5685:3: () otherlv_1= Byte_1
            {
            // InternalRos2Parser.g:5685:3: ()
            // InternalRos2Parser.g:5686:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getByteArrayAccess().getByteKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyteArray"


    // $ANTLR start "entryRulecharArray"
    // InternalRos2Parser.g:5700:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRos2Parser.g:5700:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRos2Parser.g:5701:2: iv_rulecharArray= rulecharArray EOF
            {
             newCompositeNode(grammarAccess.getCharArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecharArray=rulecharArray();

            state._fsp--;

             current =iv_rulecharArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecharArray"


    // $ANTLR start "rulecharArray"
    // InternalRos2Parser.g:5707:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5713:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRos2Parser.g:5714:2: ( () otherlv_1= Char_1 )
            {
            // InternalRos2Parser.g:5714:2: ( () otherlv_1= Char_1 )
            // InternalRos2Parser.g:5715:3: () otherlv_1= Char_1
            {
            // InternalRos2Parser.g:5715:3: ()
            // InternalRos2Parser.g:5716:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCharArrayAccess().getCharKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecharArray"


    // $ANTLR start "entryRuleHeader"
    // InternalRos2Parser.g:5730:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRos2Parser.g:5730:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRos2Parser.g:5731:2: iv_ruleHeader= ruleHeader EOF
            {
             newCompositeNode(grammarAccess.getHeaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHeader=ruleHeader();

            state._fsp--;

             current =iv_ruleHeader; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalRos2Parser.g:5737:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5743:2: ( ( () otherlv_1= Header ) )
            // InternalRos2Parser.g:5744:2: ( () otherlv_1= Header )
            {
            // InternalRos2Parser.g:5744:2: ( () otherlv_1= Header )
            // InternalRos2Parser.g:5745:3: () otherlv_1= Header
            {
            // InternalRos2Parser.g:5745:3: ()
            // InternalRos2Parser.g:5746:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getHeaderAccess().getHeaderAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Header,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getHeaderAccess().getHeaderKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleSpecBaseRef"
    // InternalRos2Parser.g:5760:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRos2Parser.g:5760:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRos2Parser.g:5761:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
            {
             newCompositeNode(grammarAccess.getSpecBaseRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecBaseRef=ruleSpecBaseRef();

            state._fsp--;

             current =iv_ruleSpecBaseRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecBaseRef"


    // $ANTLR start "ruleSpecBaseRef"
    // InternalRos2Parser.g:5767:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5773:2: ( ( ( ruleEString ) ) )
            // InternalRos2Parser.g:5774:2: ( ( ruleEString ) )
            {
            // InternalRos2Parser.g:5774:2: ( ( ruleEString ) )
            // InternalRos2Parser.g:5775:3: ( ruleEString )
            {
            // InternalRos2Parser.g:5775:3: ( ruleEString )
            // InternalRos2Parser.g:5776:4: ruleEString
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSpecBaseRefRule());
            				}
            			

            				newCompositeNode(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecBaseRef"


    // $ANTLR start "entryRuleArraySpecRef"
    // InternalRos2Parser.g:5793:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRos2Parser.g:5793:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRos2Parser.g:5794:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
            {
             newCompositeNode(grammarAccess.getArraySpecRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecRef=ruleArraySpecRef();

            state._fsp--;

             current =iv_ruleArraySpecRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArraySpecRef"


    // $ANTLR start "ruleArraySpecRef"
    // InternalRos2Parser.g:5800:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5806:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRos2Parser.g:5807:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRos2Parser.g:5807:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRos2Parser.g:5808:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRos2Parser.g:5808:3: ( ( ruleEString ) )
            // InternalRos2Parser.g:5809:4: ( ruleEString )
            {
            // InternalRos2Parser.g:5809:4: ( ruleEString )
            // InternalRos2Parser.g:5810:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_60);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArraySpecRef"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalRos2Parser.g:5832:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRos2Parser.g:5832:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRos2Parser.g:5833:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
             newCompositeNode(grammarAccess.getKEYWORDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;

             current =iv_ruleKEYWORD.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalRos2Parser.g:5839:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5845:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRos2Parser.g:5846:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRos2Parser.g:5846:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt78=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt78=1;
                }
                break;
            case Message:
                {
                alt78=2;
                }
                break;
            case Result:
                {
                alt78=3;
                }
                break;
            case Feedback:
                {
                alt78=4;
                }
                break;
            case Name:
                {
                alt78=5;
                }
                break;
            case Value:
                {
                alt78=6;
                }
                break;
            case Service:
                {
                alt78=7;
                }
                break;
            case Type:
                {
                alt78=8;
                }
                break;
            case Action:
                {
                alt78=9;
                }
                break;
            case Duration:
                {
                alt78=10;
                }
                break;
            case Time:
                {
                alt78=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalRos2Parser.g:5847:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:5853:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:5859:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos2Parser.g:5865:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos2Parser.g:5871:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos2Parser.g:5877:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos2Parser.g:5883:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos2Parser.g:5889:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos2Parser.g:5895:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos2Parser.g:5901:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos2Parser.g:5907:3: kw= Time
                    {
                    kw=(Token)match(input,Time,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTimeKeyword_10());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleEString"
    // InternalRos2Parser.g:5916:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRos2Parser.g:5916:47: (iv_ruleEString= ruleEString EOF )
            // InternalRos2Parser.g:5917:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRos2Parser.g:5923:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5929:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRos2Parser.g:5930:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRos2Parser.g:5930:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_STRING) ) {
                alt79=1;
            }
            else if ( (LA79_0==RULE_ID) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalRos2Parser.g:5931:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:5939:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleRosNames"
    // InternalRos2Parser.g:5950:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRos2Parser.g:5950:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRos2Parser.g:5951:2: iv_ruleRosNames= ruleRosNames EOF
            {
             newCompositeNode(grammarAccess.getRosNamesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRosNames=ruleRosNames();

            state._fsp--;

             current =iv_ruleRosNames.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosNames"


    // $ANTLR start "ruleRosNames"
    // InternalRos2Parser.g:5957:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos2Parser.g:5963:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node ) )
            // InternalRos2Parser.g:5964:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node )
            {
            // InternalRos2Parser.g:5964:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node )
            int alt80=3;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt80=1;
                }
                break;
            case RULE_ID:
                {
                alt80=2;
                }
                break;
            case Node:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalRos2Parser.g:5965:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos2Parser.g:5973:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos2Parser.g:5981:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosNames"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA77 dfa77 = new DFA77(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\10\12\uffff";
    static final String dfa_3s = "\1\175\12\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_5s = "\1\0\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\7\11\uffff\1\5\4\uffff\1\6\1\10\6\uffff\1\12\3\uffff\1\11\4\uffff\1\3\2\uffff\1\2\33\uffff\1\4\65\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 287:6: ( ({...}? => ( ({...}? => (otherlv_3= Profile ( ( (lv_QoSProfile_4_1= Default_qos | lv_QoSProfile_4_2= Services_qos | lv_QoSProfile_4_3= Sensor_qos | lv_QoSProfile_4_4= Parameter_qos ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= History ( ( (lv_History_6_1= Keep_last | lv_History_6_2= Keep_all ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Depth ( (lv_Depth_8_0= ruleInteger0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Reliability ( ( (lv_Reliability_10_1= Best_effort | lv_Reliability_10_2= Reliable ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Durability ( ( (lv_Durability_12_1= Transient_local | lv_Durability_12_2= Volatile ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Lease_duration ( ( (lv_LeaseDuration_14_1= ruleEString | lv_LeaseDuration_14_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Liveliness ( ( (lv_Liveliness_16_1= Automatic | lv_Liveliness_16_2= Manual ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Lifespan ( ( (lv_Lifespan_18_1= ruleEString | lv_Lifespan_18_2= Infinite ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Deadline ( ( (lv_Deadline_20_1= ruleEString | lv_Deadline_20_2= Infinite ) ) ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                         
                        int index14_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_0==RULE_END) ) {s = 1;}

                        else if ( LA14_0 == Profile && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 0) ) {s = 2;}

                        else if ( LA14_0 == History && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 1) ) {s = 3;}

                        else if ( LA14_0 == Depth && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 2) ) {s = 4;}

                        else if ( LA14_0 == Reliability && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 3) ) {s = 5;}

                        else if ( LA14_0 == Durability && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 4) ) {s = 6;}

                        else if ( LA14_0 == Lease_duration && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 5) ) {s = 7;}

                        else if ( LA14_0 == Liveliness && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 6) ) {s = 8;}

                        else if ( LA14_0 == Lifespan && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 7) ) {s = 9;}

                        else if ( LA14_0 == Deadline && getUnorderedGroupHelper().canSelect(grammarAccess.getQualityOfServiceAccess().getUnorderedGroup_2(), 8) ) {s = 10;}

                         
                        input.seek(index14_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\1\10\2\11\10\uffff";
    static final String dfa_8s = "\3\143\4\uffff\1\151\3\uffff";
    static final String dfa_9s = "\3\175\4\uffff\1\174\3\uffff";
    static final String dfa_10s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
            "\1\10\5\uffff\1\10\1\uffff\1\7\1\10\1\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1\3\uffff\1\10",
            "\1\11\5\uffff\1\11\1\10\1\uffff\1\11\13\uffff\2\11\3\uffff\1\11",
            "\1\11\5\uffff\1\11\1\10\1\uffff\1\11\13\uffff\2\11\3\uffff\1\11",
            "",
            "",
            "",
            "",
            "\1\12\1\uffff\2\12\1\uffff\4\12\6\uffff\2\12\2\uffff\1\10",
            "",
            "",
            ""
    };
    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = dfa_1;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "3194:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_13s = "\44\uffff";
    static final String dfa_14s = "\36\uffff\2\43\4\uffff";
    static final String dfa_15s = "\1\40\35\uffff\2\46\4\uffff";
    static final String dfa_16s = "\1\171\35\uffff\2\173\4\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_18s = "\44\uffff}>";
    static final String[] dfa_19s = {
            "\1\32\1\33\4\uffff\1\17\7\uffff\1\34\1\25\1\27\1\31\3\uffff\1\12\1\13\1\24\1\26\1\30\3\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\1\uffff\1\22\2\uffff\1\14\1\5\1\7\1\11\2\uffff\1\4\1\6\1\10\4\uffff\1\3\3\uffff\1\1\1\15\1\40\1\uffff\1\2\3\uffff\1\16\23\uffff\1\37\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\43\22\uffff\1\43\1\uffff\1\43\6\uffff\1\43\6\uffff\1\43\16\uffff\1\43\5\uffff\1\43\1\uffff\1\43\2\uffff\2\43\2\uffff\1\42\17\uffff\2\43\1\uffff\1\43",
            "\2\43\22\uffff\1\43\1\uffff\1\43\6\uffff\1\43\6\uffff\1\43\16\uffff\1\43\5\uffff\1\43\1\uffff\1\43\2\uffff\2\43\2\uffff\1\42\17\uffff\2\43\1\uffff\1\43",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "4529:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000008024000L,0x2000000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008004000L,0x2000000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0xA100000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L,0x2000000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L,0x0300000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000120000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000090881840100L,0x2000000000000080L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010488000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000100000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0004000000000800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L,0x0300000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x2000008800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x2000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xC018000000000000L,0x0000000008010006L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x2000008800008000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x2000000800008000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0303C80000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000024000L,0x2000000000500000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000004000L,0x2000000000500000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L,0x2000000000500000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x2300000000000003L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x2300000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x23E3C04300000000L,0x23000011710E7971L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000400L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000008000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x23E3C04300000002L,0x03000011710E7971L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x2000000000200000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x8100000400000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000006103602L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0300100000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x140000C000000000L,0x0B00003282000408L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});

}
