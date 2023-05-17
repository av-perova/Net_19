import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = { "Молоко", "Яйца", "Хлеб", "Позвонить" };
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSimpleTaskContainsQuery() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfEpicContainsQuery() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { epic };
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfMeetingContainsQuery() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfTwoTasksContainsQuery() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic };
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotContainsQuery() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {  };
        Task[] actual = todos.search("Тест");
        Assertions.assertArrayEquals(expected, actual);
    }
}
