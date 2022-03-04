package kyivQuestWeb.service;

import kyivQuestWeb.model.Question;
import kyivQuestWeb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll(){
        return questionRepository.findAll();
    }
}
