import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TasksTest {

        @Test
        public void shouldSearchQueryInSimpleTask() {
            Task simpleTask = new SimpleTask(5, "Позвонить родителям");

            boolean expected = true;
            boolean actual = simpleTask.matches("Позвонить");

            Assertions.assertEquals(expected, actual);
        }
        @Test
        public void shoulNotSearchQueryInSimpleTask() {
            Task simpleTask = new SimpleTask(5, "Позвонить родителям");

            boolean expected = false;
            boolean actual = simpleTask.matches("маме");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldSearchQueryInEpic() {
            String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
            Task epic = new Epic(55, subtasks);

            boolean expected = true;
            boolean actual = epic.matches("Яйца");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shoulNotSearchQueryInEpic() {
            String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
            Task epic = new Epic(55, subtasks);

            boolean expected = false;
            boolean actual = epic.matches("Вода");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldSearchQueryInMeeting() {
            Task meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );

            boolean expected = true;
            boolean actual = meeting.matches(" 3й ");

            Assertions.assertEquals(expected, actual);
        }
    @Test
    public void shouldSearchQueryInProject() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }
        @Test
        public void shoulNotSearchQueryInMeeting() {
            Task meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );

            boolean expected = false;
            boolean actual = meeting.matches("Нетобанка");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shoulNotSearchQueryInTask() {
            Task task = new Task(555);

            boolean expected = false;
            boolean actual = task.matches("до");

            Assertions.assertEquals(expected, actual);
        }



    @Test
    public void shouldSearchEquals() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        System.out.println(meeting.equals(meeting));
    }
    @Test
    public void shouldCompareDifferentClasses() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        System.out.println(simpleTask.equals(epic));
    }
    @Test
    public void shouldDefineHashCode() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        System.out.println(simpleTask.hashCode());

    }

}
