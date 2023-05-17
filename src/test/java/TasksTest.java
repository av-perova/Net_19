import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindIfSimpleTaskContainsQuery() {
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIfEpicContainsQuery() {
        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIfMeetingContainsQuery() {
        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDoNotFindIfSimpleTaskNotContainsQuery() {
        boolean expected = false;
        boolean actual = simpleTask.matches("Тест");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDoNotFindIfEpicNotContainsQuery() {
        boolean expected = false;
        boolean actual = epic.matches("Тест");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDoNotFindIfMeetingNotContainsQuery() {
        boolean expected = false;
        boolean actual = meeting.matches("Тест");

        Assertions.assertEquals(expected, actual);
    }

}

