package smolbrain.command;

import smolbrain.Storage;
import smolbrain.Ui;
import smolbrain.exception.InvalidCommandException;
import smolbrain.task.TaskList;

/**
 * Handles an invalid or unknown command given by user.
 */
public class InvalidCommand implements Command {

    private boolean isLoading;

    /**
     * Creates an invalid command.
     */
    public InvalidCommand() {

    }

    /**
     * Executes this command.
     *
     * @param tasks List of tasks of chatbot.
     * @param ui Ui manager of chatbot.
     * @param storage Storage manager of chatbot.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError(new InvalidCommandException());
    }

    /**
     * Sets the flag that chatbot is loading to true.
     */
    @Override
    public void setLoading() {
        this.isLoading = true;
    }

}
