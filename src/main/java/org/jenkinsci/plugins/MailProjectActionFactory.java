package org.jenkinsci.plugins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import hudson.Extension;
import hudson.model.Action;
import hudson.model.TransientProjectActionFactory;
import hudson.model.AbstractProject;

@Extension
public class MailProjectActionFactory extends TransientProjectActionFactory {

    /** Our logger. */
    // private static final Logger LOG =
    // Logger.getLogger(MailProjectActionFactory.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends Action> createFor(
            @SuppressWarnings("rawtypes") AbstractProject target) {
        final List<JobMailProjectAction> projectActions = target
                .getActions(JobMailProjectAction.class);
        final ArrayList<Action> actions = new ArrayList<Action>();
        if (projectActions.isEmpty()) {
            final JobMailProjectAction newAction = new JobMailProjectAction(target);
            actions.add(newAction);
            return actions;
        } else {
            return projectActions;
        }
    }

}
