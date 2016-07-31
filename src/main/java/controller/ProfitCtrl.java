package controller;

import domain.Profit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.ProfitService;
import tools.ExcelTools;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ProfitCtrl {

	@Autowired
	private ProfitService profitService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 数据获取
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
	 * 上传保存的方法
	 * @param file: 前端上传的post的文件file
	 * @return
	 * 保存地址：AngularFunctionTesting\target\demo\saveFile\
	 */
	@ResponseBody
	@RequestMapping(value = "/upLoadFile.req", method = RequestMethod.POST)
	public String upLoadExcelFile(@RequestParam("file") MultipartFile file) {

//		String path = request.getServletContext().getRealPath("/saveFile/");

		try {

//			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path,file.getOriginalFilename()));


			ExcelTools tools = new ExcelTools();

			List<Profit> list=tools.getDataFromExcel(file.getInputStream());

			if (list.size() != 0) {

				profitService.toSavePartData(list);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}

