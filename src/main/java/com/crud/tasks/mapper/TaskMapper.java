package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class TaskMapper {
    public Task mapToTask(final TaskDto taskDto){
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getContent()
        );
    }
    public TaskDto mapToTaskDto (final Task task){
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getContent()
        );
    }
    public List<TaskDto> maptoTaskDtoList (final List<Task> taskList){
        return taskList.stream()
                .map(this::mapToTaskDto)
                .toList();
    }
}
