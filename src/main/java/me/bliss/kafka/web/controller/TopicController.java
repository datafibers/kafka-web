package me.bliss.kafka.web.controller;

import me.bliss.kafka.web.component.ZookeeperComponent;
import me.bliss.kafka.web.component.model.Topic;
import me.bliss.kafka.web.component.model.TopicMessage;
import me.bliss.kafka.web.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 *
 * @author lanjue
 * @version $Id: me.bliss.kafka.web.controller, v 0.1 4/4/15
 *          Exp $
 */
@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ZookeeperComponent zookeeperComponent;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Topic> getList() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<TopicMessage> getAllMessages() {
        return topicService.getMessage();
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void setZookeeperComponent(ZookeeperComponent zookeeperComponent) {
        this.zookeeperComponent = zookeeperComponent;
    }
}
