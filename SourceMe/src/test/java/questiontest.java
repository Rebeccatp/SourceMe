import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class questiontest {
	private static Question question = new Question(0, null, null, null);
	private static int questionId;
	private static int deleteQuestionId;
	private static Question questionById;
	
	
	@BeforeAll
    public static void setup() {
		questionId = 32;
		question.addQuestion("Kpop", "Jisoo show", "Zann");	
		List<Question> allQuestions = question.getAllQuestions();
		int listSize = allQuestions.size();
		int getIndex = listSize-1;
		deleteQuestionId= allQuestions.get(getIndex).getId();
    }

	@Test
	void testGetAllQuestions() {
		//Act
		List<Question> testQc = question.getAllQuestions();
		//Assert
		assertFalse(testQc.isEmpty());
	}

	@Test
	void testGetQuestionByID() {
		//Act
		questionById = question.getQuestionByID(questionId);
		//Assert
		assertFalse(questionById.equals(null));
	}

	@Test
	void testAddQuestion() {
		List<Question> testQc = question.getAllQuestions();	
		int beforeSize = testQc.size();	
		// Act
		boolean isAdded = question.addQuestion("Kdrama", "ROMCOM Recommendation", "Kelsey");	
		List<Question> testAfterQc = question.getAllQuestions();	
		int afterSize = testAfterQc.size();	
		assertEquals(beforeSize+1, afterSize);
		assertEquals(isAdded, true);
	}

	@Test
	void testUpdateQn() {
		questionById = question.getQuestionByID(questionId);
		boolean isUpdated = question.updateQn("Kpop", "Jisoo songs and drama", "Kelsey", questionId);	
		assertEquals(isUpdated, true);
	}

	@Test
	void testDeleteQn() {
		List<Question> testQc = question.getAllQuestions();	
		int beforeSize = testQc.size();	
		// Act
		boolean isDeleted = question.deleteQn(deleteQuestionId);	
		List<Question> testAfterQc = question.getAllQuestions();	
		int afterSize = testAfterQc.size();	
		assertEquals(beforeSize-1, afterSize);
		assertEquals(isDeleted, true);
	}

}
