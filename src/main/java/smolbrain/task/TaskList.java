package smolbrain.task;

import java.io.IOException;
import java.util.ArrayList;

import smolbrain.Storage;
import smolbrain.Ui;

/**
 * List of tasks for chatbot.
 */
public class TaskList {

    private ArrayList<Task> tasklist;
    private Ui ui;

    /**
     * Creates a tasklist with the given ArrayList of tasks.
     *
     * @param tasklist Tasklist using given ArrayList.
     * @param ui Ui object used for this application.
     */
    public TaskList(ArrayList<Task> tasklist, Ui ui) {
        this.tasklist = tasklist;
        this.ui = ui;
    }

    /**
     * Adds the given task into tasklist.
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasklist.add(task);
    }

    /**
     * Deletes the given task from tasklist.
     * @param id Id of task to delete.
     */
    public void deleteTask(int id) {
        tasklist.remove(id);
    }

    /**
     * Marks the given task in tasklist.
     * @param id Id of task to mark.
     */
    public void markTask(int id) {
        tasklist.get(id).mark();
    }

    /**
     * Unmarks the given task in tasklist.
     * @param id Id of task to unmark.
     */
    public void unmarkTask(int id) {
        tasklist.get(id).unmark();
    }

    /**
     * Sets the priority the given task in tasklist.
     * @param id Id of task to set priority.
     * @param level Priority level to set.
     */
    public void setTaskPriority(int id, int level) {
        tasklist.get(id).setPriorityLevel(level);
    }

    /**
     * Returns the number of tasks in tasklist.
     *
     * @return Number of tasks in tasklist.
     */
    public int getSize() {
        return tasklist.size();
    }

    /**
     * Displays all the tasks in tasklist.
     *
     * @param ui Ui manager of chatbot.
     */
    public void displayTasks(Ui ui) {
        if (tasklist.size() == 0) {
            ui.showMessage("You have no tasks currently.");
            return;
        }
        String message = "Here are the tasks in your list: \n";
        for (int i = 0; i < tasklist.size(); i++) {
            message += (i + 1) + ". " + tasklist.get(i) + "\n";
        }
        ui.showMessage(message);
    }

    /**
     * Returns the specified task in tasklist.
     * @param id Id of task to retrieve.
     * @return Task at the specified id.
     */
    public Task getTask(int id) {
        return tasklist.get(id);
    }

    /**
     * Saves the tasks in tasklist into save file.
     *
     * @param storage Storage manager of chatbot.
     */
    public void updateTasks(Storage storage) {
        try {
            if (tasklist.size() == 0) {
                storage.writeToFile("");
                return;
            }
            for (int i = 0; i < tasklist.size(); i++) {
                if (i == 0) {
                    storage.writeToFile(tasklist.get(i).encode());
                } else {
                    storage.appendToFile(System.lineSeparator() + tasklist.get(i).encode());
                }
            }
        } catch (IOException e) {
            ui.showError(e);
        }
    }

    /**
     * Finds and prints all the tasks in tasklist that contain the keyword.
     *
     * @param keyword Keyword to check.
     * @param ui Ui manager of chatbot.
     */
    public void findTasks(String keyword, Ui ui) {
        if (tasklist.size() <= 0) {
            return;
        }
        String message = "";
        for (int i = 0; i < tasklist.size(); i++) {
            if (tasklist.get(i).contain(keyword)) {
                message += ((i + 1) + ". " + tasklist.get(i) + "\n");
            }
        }
        ui.showMessage(message);
    }

}
