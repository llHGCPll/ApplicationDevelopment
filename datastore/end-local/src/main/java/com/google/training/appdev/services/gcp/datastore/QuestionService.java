/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.training.appdev.services.gcp.datastore;

import com.google.cloud.datastore.*;
import com.google.training.appdev.services.gcp.domain.Question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private ArrayList<Question> questionArrayList = new ArrayList<>();

    public void createQuestion(Question question) {
        questionArrayList.add(question);

    }

    public List<Question> getAllQuestions(String quiz) {

        List<Question> array = questionArrayList
                .stream()
                .filter(question -> Objects.equals(question.getQuiz(), quiz))
                .collect(Collectors.toList());


        return array;
    }


/* TODO: Uncomment this block

    private List<Question> buildQuestions(Iterator<Entity> entities){
        List<Question> questions = new ArrayList<>();
        entities.forEachRemaining(entity-> questions.add(entityToQuestion(entity)));
        return questions;
    }

    private Question entityToQuestion(Entity entity){
        return new Question.Builder()
                .withQuiz(entity.getString(Question.QUIZ))
                .withAuthor(entity.getString(Question.AUTHOR))
                .withTitle(entity.getString(Question.TITLE))
                .withAnswerOne(entity.getString(Question.ANSWER_ONE))
                .withAnswerTwo(entity.getString(Question.ANSWER_TWO))
                .withAnswerThree(entity.getString(Question.ANSWER_THREE))
                .withAnswerFour(entity.getString(Question.ANSWER_FOUR))
                .withCorrectAnswer(entity.getLong(Question.CORRECT_ANSWER))
                .withId(entity.getKey().getId())
                .build();
    }

*/
}
