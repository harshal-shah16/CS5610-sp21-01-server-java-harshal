package com.example.webdev.services;


import com.example.webdev.repositories.WidgetRepository;
import com.example.webdev.models.Widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;


  // implement crud operations
  public Widget createWidgetForTopic(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);

  }
  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();

  }
  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);

  }
  public Widget findWidgetById(Long id) {
    return repository.findWidgetById(id);

  }
  public Integer updateWidget(Long id, Widget newWidget) {
    Widget originalWidget = findWidgetById(id);

    originalWidget.setText(newWidget.getText());
    originalWidget.setUrl(newWidget.getUrl());
    originalWidget.setHeight(newWidget.getHeight());
    originalWidget.setWidth(newWidget.getWidth());
    originalWidget.setOrdered(newWidget.getOrdered());
    originalWidget.setType(newWidget.getType());
    originalWidget.setSize(newWidget.getSize());

    repository.save(originalWidget);
    return 1;

  }
  public Integer deleteWidget(Long id) {

    repository.deleteById(id);
    return 1;

  }
}