package controller;

import domain.Profit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.ProfitService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProfitCtrl {

	@Autowired
	private ProfitService profitService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 数据获取
	 *
	 * @param pageNo：页码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/profitDatas", method = RequestMethod.POST)
	public Page<Profit> toGetProfitData(@RequestParam("pageNO") Integer pageNo) {

		System.out.println("profit's request pageNO" + pageNo);

		return profitService.toGetAllData(pageNo);
	}


	/**
	 * 上传保存的方法，转换为输入流，用poi解析excel数据
	 *
	 * @param file: 前端上传的post的文件file
	 * @return 保存地址：AngularFunctionTesting\target\demo\saveFile\
	 */
	@ResponseBody
	@RequestMapping(value = "/upLoadFile.req", method = RequestMethod.POST)
	public String upLoadExcelFile(@RequestParam("file") MultipartFile file) {

		/**   保存文件位置  **/
		//		String path = request.getServletContext().getRealPath("/saveFile/");

		try {

			/**   保存命令  **/
			//			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path,file.getOriginalFilename()));


			List<Profit> list = getDataFromExcel(file.getInputStream());

			/**   保存尾数不满足100的数据  **/
			if (list.size() != 0) {

				profitService.toSavePartData(list);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 解析excel表格,边解析边保存
	 *
	 * @param is 文件输入流
	 * @return
	 */
	public List<Profit> getDataFromExcel(InputStream is) {

		System.out.println("开始获取Excel表格数据......");

		List<Profit> goalData = new ArrayList<Profit>();

		try {
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);

			int firstRow = sheet.getFirstRowNum();
			int lastRow = sheet.getLastRowNum();

			for (int i = firstRow + 1; i <= lastRow; i++) {

				System.out.println("正在转换第【" + i + "】行数据.......");

				XSSFRow curRow = sheet.getRow(i);

				if (curRow == null) {
					continue;
				}

				int firstCell = curRow.getFirstCellNum();
				int lastCell = curRow.getLastCellNum();

				List<String> tempSaveData = new ArrayList<String>();

				for (int j = firstCell; j < lastCell; j++) {

					XSSFCell curCell = null;

					if (curRow.getCell(j) == null) {

						curCell = curRow.createCell(j);
						curCell.setCellValue(new XSSFRichTextString(""));
					} else {

						curCell = curRow.getCell(j);

					}
					//					System.out.println("add item: :" + curCell.getStringCellValue());
					tempSaveData.add(parseCellValue(curCell));

				}

				goalData.add(new Profit(tempSaveData.get(0), tempSaveData.get(1), tempSaveData.get(2).equals("") ? 0 : Float.parseFloat(tempSaveData.get(2)), tempSaveData.get(3).equals("") ? 0 : Float.parseFloat(tempSaveData.get(3)), tempSaveData.get(4).equals("") ? 0 : Float.parseFloat(tempSaveData.get(4)), tempSaveData.get(5), tempSaveData.get(6), tempSaveData.get(7), tempSaveData.get(8), tempSaveData.get(9), tempSaveData.get(10), tempSaveData.get(11), tempSaveData.get(12), tempSaveData.get(13), tempSaveData.get(14), tempSaveData.get(15), tempSaveData.get(16), tempSaveData.get(17), tempSaveData.get(18), tempSaveData.get(19)));
				tempSaveData.clear();


				/**   集合满100保存，最后不够100的数据返回调用处再保存  **/
				if (goalData.size() % 100 == 0) {

					System.out.println("中转集合满100，保存到数据库中。。。。");

					profitService.toSavePartData(goalData);

					System.out.println("100条数据保存完成，接着清空集合再解析excel数据！！！！！");
					goalData.clear();
				}
			}

			System.out.println("转换完毕.......返回不够整百的数据到调用处保存....");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return goalData;
	}


	/**
	 * 根据单元格的格式，处理格式，然后返回对象的数据
	 *
	 * @param cell 传入的单元格
	 * @return
	 */
	public String parseCellValue(Cell cell) {

		String result = new String();

		switch (cell.getCellType()) {

			case Cell.CELL_TYPE_NUMERIC:

				if (DateUtil.isCellDateFormatted(cell)) {

					/**   获取excel的时间日期内容，用 DataFormatter **/
					DataFormatter formatter = new DataFormatter();
					String time = formatter.formatCellValue(cell);

					try {
						/**   先把string的日期转为Date，time的格式不符合时间格式，需要再转换  **/
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm");
						Date date = sdf.parse(time);

						/**   转为符合阅读习惯的顺序  **/
						sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
						result = sdf.format(date);

					} catch (ParseException e) {
						e.printStackTrace();
					}

				} else {

					/**   纯数字的单元格，需要转为string再读取，否则出错 ：要特别处理小数点 **/
					// 返回数值类型的值
					Object inputValue = null;// 单元格值
					Long longVal = Math.round(cell.getNumericCellValue());
					Double doubleVal = cell.getNumericCellValue();

					if (Double.parseDouble(longVal + ".0") == doubleVal) {   //判断是否含有小数位.0
						inputValue = longVal;
					} else {
						inputValue = doubleVal;
					}

					result = String.valueOf(inputValue);
				}

				break;

			case Cell.CELL_TYPE_STRING:

				result = cell.getRichStringCellValue().toString();
				break;

			case Cell.CELL_TYPE_BLANK:
				result = "";
				break;
			default:
				result = "";
				break;
		}
		return result;
	}


}

