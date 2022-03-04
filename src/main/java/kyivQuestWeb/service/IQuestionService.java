package kyivQuestWeb.service;

import kyivQuestWeb.model.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> findAll();
}
