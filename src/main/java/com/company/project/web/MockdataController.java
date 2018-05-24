package com.company.project.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.common.JSONUtil;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Mockdata;
import com.company.project.model.Project;
import com.company.project.service.MockdataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

/**
 * Created by CodeGenerator on 2018/05/22.
 */
@RestController
@RequestMapping("/mockdata")
public class MockdataController {
	@Resource
	private MockdataService mockdataService;

	@PostMapping("/add")
	public Result addString(@NotNull @NotBlank @RequestParam(value = "json") String mockdata,
			@NotNull @NotBlank Integer projectId) throws Exception {
		if (mockdata == null || "".equals(mockdata) || projectId == null || "".equals(projectId)) {
			return ResultGenerator.genFailResult("json数据不能为空！");
		}
		if (projectId == null || "".equals(projectId)) {
			return ResultGenerator.genFailResult("项目ID不能为空！");
		}
		Mockdata mockdata2 = new Mockdata();
		mockdata2.setProjectId(projectId);
		try {
			Map<String, Object> maps = JSONUtil.json2Map(mockdata);
			mockdata2.setContent(mockdata);
			Map<String, Object> requestMap = (Map<String, Object>) maps.get("request");
			mockdata2.setMethod(requestMap.get("method").toString());
			mockdata2.setInterfasename(requestMap.get("url").toString());
			Map<String, Object> responseMap = (Map<String, Object>) maps.get("response");
			mockdata2.setStatus(responseMap.get("status").toString());
			mockdata2.setHeaders(responseMap.get("headers").toString());
		} catch (Exception e) {
			throw new Exception("内部json转换问题！联系管理员！");
		}
		mockdataService.save(mockdata2);
		return ResultGenerator.genSuccessResult();
	}

	// @PostMapping("/add")
	// public Result add(Mockdata mockdata) {
	// mockdataService.save(mockdata);
	// return ResultGenerator.genSuccessResult();
	// }

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		mockdataService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(Mockdata mockdata) {
		mockdataService.update(mockdata);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		Mockdata mockdata = mockdataService.findById(id);
		return ResultGenerator.genSuccessResult(mockdata);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			Integer projectId) {
		PageHelper.startPage(page, size);
		Condition condition = new Condition(Project.class);
		condition.createCriteria().andCondition("project_id=" + projectId);
		List<Mockdata> list = mockdataService.findByCondition(condition);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@PostMapping("/mockservice/{operateCode}")
	public Result wireMockService(@PathVariable String operateCode) {
		if (operateCode == null || operateCode.equals("")) {
			return ResultGenerator.genFailResult("operateCode 不能为空或者为null！");
		}
		if ("WIRE_MOCK_START".equals(operateCode)) {
			System.err.println("WIRE_MOCK_START");
		} else if ("WIRE_MOCK_STOP".equals(operateCode)) {
			System.err.println("WIRE_MOCK_STOP");
		} else if ("WIRE_MOCK_RESET".equals(operateCode)) {
			System.err.println("WIRE_MOCK_RESET");
		}else {
			return ResultGenerator.genFailResult("operateCode 不正确！");
		}
		return ResultGenerator.genSuccessResult();
	}
}
