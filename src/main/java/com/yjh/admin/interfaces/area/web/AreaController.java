package com.yjh.admin.interfaces.area.web;

import com.yjh.admin.application.area.IAreaAppService;
import com.yjh.admin.application.area.command.AreaListCommand;
import com.yjh.admin.application.area.representation.AreaRepresentation;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yjh on 2015/7/28.
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaAppService areaAppService;

    @RequestMapping(value = "/list")
    public ModelAndView list(AreaListCommand command){
        Pagination<AreaRepresentation> pagination = areaAppService.listPagination(command);
        return new ModelAndView("/area/list","pagination",pagination).addObject("command",command);
    }



}
