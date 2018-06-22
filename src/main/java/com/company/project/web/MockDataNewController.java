package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MockDataNew;
import com.company.project.service.MockDataNewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/19.
*/
@RestController
@RequestMapping("/mock/data/new")
public class MockDataNewController {
    @Resource
    private MockDataNewService mockDataNewService;

    @PostMapping("/add")
    public Result add(MockDataNew mockDataNew) {
        mockDataNewService.save(mockDataNew);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        mockDataNewService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MockDataNew mockDataNew) {
        mockDataNewService.update(mockDataNew);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MockDataNew mockDataNew = mockDataNewService.findById(id);
        return ResultGenerator.genSuccessResult(mockDataNew);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MockDataNew> list = mockDataNewService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
