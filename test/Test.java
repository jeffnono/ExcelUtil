import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.nami.excelexport.module.ExcelModule;
import com.nami.excelexport.userinterface.ExcelExpUtil;
import com.nami.excelimport.bean.ExcelData;
import com.nami.excelimport.userinterface.ExcelImportUtil;
import com.nami.excelimport.util.ExcelDataUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		// 读取excel导入的数据
		// ExcelData data = testBigGridExcelImp();
		System.out.print("3U".substring(0, 2));
		// 将数据通过excel模板输出
		// testExcelExp(ExcelDataUtil.changeExcelDataToSimple(data).getRepeatData());
	}

	/**
	 * 测试excel导入
	 */
	private static ExcelData testBigGridExcelImp() throws Exception {

		String xmlPath = "E:/交接文档/财务/20140311/";
		String xmlFile = xmlPath + "b2b-ETWIN.xml";
		String excelFile = xmlPath + "b2b-ETWIN20140306.xls";
		InputStream importExcelStream = new FileInputStream(excelFile);
		ExcelData data = ExcelImportUtil.readExcel(new FileInputStream(xmlFile), importExcelStream);
		System.out.println(data);
		return data;
	}

	/**
	 * 测试excel导入
	 */
	private static ExcelData testExcelImp() throws Exception {
		String xmlFile = "excel_desc.xml";
		InputStream importExcelStream = new FileInputStream("info_CRM.xls");
		ExcelData data = ExcelImportUtil.readExcel(new FileInputStream(xmlFile), importExcelStream);
		System.out.println(data);
		return data;
	}

	/**
	 * 测试excel导出
	 */
	private static void testExcelExp(List<Map<String, String>> sheet_data_all) throws Exception {
		ExcelModule excelModule = new ExcelModule(sheet_data_all);
		// 导出excel时使用的模板：exp_templete.xls
		String templeteFile = new File("D:/java/opensource/poi/ExcelUtil", "exp_templete.xls").getAbsolutePath();
		System.out.println(templeteFile);
		// 导出的文件名：exp_out.xls
		ExcelExpUtil.expExcel(excelModule, templeteFile, "exp_out.xls");
	}
}