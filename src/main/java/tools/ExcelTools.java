package tools;

import domain.Profit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProfitService;
import service.StudentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/7/30 22:05
 */

@Service
public class ExcelTools {


	@Autowired
	private ProfitService profitService;

	@Autowired
	private StudentService studentService;


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
						if (curCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {


							curCell.setCellType(Cell.CELL_TYPE_STRING);

						}
					}

					tempSaveData.add(curCell.getStringCellValue());

				}

				goalData.add(new Profit(tempSaveData.get(0), tempSaveData.get(1), tempSaveData.get(2).equals("") ? 0 : Integer.parseInt(tempSaveData.get(2)), tempSaveData.get(3).equals("") ? 0 : Integer.parseInt(tempSaveData.get(3)), tempSaveData.get(4).equals("") ? 0 : Integer.parseInt(tempSaveData.get(4)), tempSaveData.get(5), tempSaveData.get(6), tempSaveData.get(7), tempSaveData.get(8), tempSaveData.get(9), tempSaveData.get(10), tempSaveData.get(11), tempSaveData.get(12), tempSaveData.get(13), tempSaveData.get(14), tempSaveData.get(15), tempSaveData.get(16), tempSaveData.get(17), tempSaveData.get(18), tempSaveData.get(19)));
				tempSaveData.clear();

				if (goalData.size() % 100 == 0) {

					System.out.println("已经满足1次，保存中。。。。");

					System.out.println(profitService);

					System.out.println("sutdfd:::"+studentService);
					System.out.println(goalData);
					profitService.toSavePartData(goalData);

					System.out.println("保存完了吗，我要清空了！！！！！");
					goalData.clear();
					System.out.println("goalData size:"+goalData.size());

				}
			}

			System.out.println("转换完毕.......");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return goalData;
	}

}
