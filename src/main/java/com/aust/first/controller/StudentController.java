package com.aust.first.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.entity.Student;
import com.aust.first.service.StudentService;
import com.aust.first.util.ExcelUtil_1;
import com.aust.first.util.ResultBean;
import com.aust.first.util.StringUtil;
import com.aust.first.vo.StudentDTO;
import com.aust.first.vo.StudentDTO2;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*
	 * 本地查询，返回自定义pojo
	 */
	@GetMapping("/lianbiao1")
	public ResultBean lianbiao1() {
		List<Object[]> list = studentService.lianbiao1();
		List<StudentDTO> listdto = new ArrayList<StudentDTO>();
		for (int i = 0; i < list.size(); i++) {
			StudentDTO s = new StudentDTO();
			Object[] obj = list.get(i);
			long a = ((BigInteger) obj[0]).longValue(); // sid , obj[0].getClass() = java.math.BigInteger
			s.setSid(a);
			s.setSname((String) obj[1]); // sname , obj[1].getClass() = java.lang.String
			int b = ((BigDecimal) obj[2]).intValue(); // totalgrade , obj[2].getClass() = java.math.BigDecimal
			s.setTotalgrade(b);
			listdto.add(s);
		}
		System.out.println(listdto);
		return ResultBean.ok(listdto);
	}
	
	@GetMapping("/lianbiao1_1")
	public ResultBean lianbiao1_1() {
		List<Object[]> list = studentService.lianbiao1();
		List<StudentDTO2> listdto = new ArrayList<StudentDTO2>();
		for (int i = 0; i < list.size(); i++) {
			StudentDTO2 s = new StudentDTO2();
			Object[] obj = list.get(i);
			s.setSid(obj[0]);
			s.setSname(obj[1]);
			s.setTotalgrade(obj[2]);
			listdto.add(s);
		}
		System.out.println(listdto);
		return ResultBean.ok(listdto);
	}

//	使用sql并返回自定义实体类DTO,mapping 映射，并将结果封装成pojo
	@GetMapping("/lianbiao2")
	public ResultBean lianbiao2() {
		List<StudentDTO> list = studentService.lianbiao2();
		System.out.println(list);
		return ResultBean.ok(list);
	}
	
//	使用sql并返回自定义实体类DTO,并将结果封装成pojo,会报错，
//	Could not locate appropriate constructor on class : mypackage.CourseCompletion
	@GetMapping("/lianbiao2_1")
	public ResultBean lianbiao2_1() {
		List<StudentDTO> list = studentService.lianbiao2_1();
		System.out.println(list);
		return ResultBean.ok(list);
	}

//	使用sql并返回自定义实体类VO，没有封装pojo
	@GetMapping("/lianbiao3")
	public ResultBean lianbiao3() {
		return ResultBean.ok(studentService.lianbiao3());
	}
	
//	使用sql返回entity
	@GetMapping("/lianbiao3_1")
	public ResultBean lianbiao3_1() {
		return ResultBean.ok(studentService.lianbiao3_1());
	}

//	使用sql并返回自定义实体类VO，没有封装pojo
	@GetMapping("/lianbiao3_2")
	public ResultBean lianbiao3_2() {
		return ResultBean.ok(studentService.lianbiao3_2());
	}
	
//	使用sql，自定义返回
	@GetMapping("/lianbiao3_3")
	public ResultBean lianbiao3_3() {
		return ResultBean.ok(studentService.lianbiao3_3());
	}
	
//	使用sql连表查询，并返回POJO
	@GetMapping("/lianbiao4")
	public ResultBean lianbiao4() {
		return ResultBean.ok(studentService.lianbiao4());
	}

	// 查询所有all，并输出到excel表中
	@GetMapping("/all")
	public List<Student> all() {
		List<Student> list = studentService.findAll();

		// 3.解析list到excel中

		int rowNum = 1;// 默认第一行
		int sheetNum = 0;// 默认第一窗栏
		FileOutputStream fos = null;
		// 创建 HSSFWorkbook 工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建工作
		HSSFSheet sheet = wb.createSheet();
		// 设定sheetsd名称即第0个sheet名称为第一窗栏
		wb.setSheetName(sheetNum, "第一窗栏");
		HSSFCellStyle cellStyle = wb.createCellStyle();
		String[] headers = new String[] { "序号", "姓名", "学号", "性别", "年龄" };// 设置表头字段
		ExcelUtil_1.setLineValue(sheet, 0, 0, cellStyle, headers);
		List<String> values = new ArrayList<>();

		values.clear();
		for (int i = 0; i < list.size(); i++) {
			Student temporary = (Student) list.get(i);
			values.add(String.valueOf(temporary.getId()));
			values.add(StringUtil.nullToString(temporary.getSname()));
			values.add(String.valueOf(temporary.getSid()));
			values.add(temporary.getSex());
			values.add(String.valueOf(temporary.getAge()));
			ExcelUtil_1.setLineValue(sheet, rowNum, 0, null, values);
			values.clear();
			rowNum++;
			if (rowNum % 100 == 0) { // 定义每个窗栏的行数，用于切换窗栏
				sheetNum++;
				rowNum = 1;
				sheet = wb.createSheet();
				wb.setSheetName(sheetNum, "downLoad" + sheetNum);
				ExcelUtil_1.setLineValue(sheet, 0, 0, null, headers);
			}
		}
		try {
			fos = new FileOutputStream("D:\\tmp\\test.xls");
			try {
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
