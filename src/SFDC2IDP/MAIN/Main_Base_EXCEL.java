package SFDC2IDP.MAIN;

import SFDC2IDP.BASE.COMMON.CONSTANTS;
import SFDC2IDP.BASE.COMMON.Helper;
import SFDC2IDP.BASE.GENERATER.GenerateDSS_SQL;
import SFDC2IDP.BASE.GENERATER.GenerateMappingDMC;
import SFDC2IDP.BASE.GENERATER.GenerateMappingIn_Schema;
import SFDC2IDP.BASE.GENERATER.GenerateMappingOut_Schema;
import SFDC2IDP.BASE.GENERATER.GenerateProxy;
import SFDC2IDP.BASE.GENERATER.TestProxy;
import SFDC2IDP.BASE.INTERFACE.IMappingHandler;
import SFDC2IDP.BASESFDCEXCEL.MAPPINGHANDLER.Handle_Mapping_BaseExcel;

public class Main_Base_EXCEL {
	public static void main(String[] args) throws Exception {
		IMappingHandler handle = Handle_Mapping_BaseExcel.getInstance(true,true);
//		new GenerateDSS_SQL(handle).execute();
		Helper.clearFiles(CONSTANTS.LOCAL_Results_BasePath+"/files/");
		new GenerateMappingDMC(handle).execute();
		new GenerateMappingIn_Schema(handle).execute();
		new GenerateMappingOut_Schema(handle).execute();
		new GenerateProxy(handle).execute();
//		new TestProxy(handle).execute();
	}
}
