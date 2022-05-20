package com.gitlabci.plugin.listeners;

import com.gitlabci.plugin.ui.GitLabCIPanel;
import com.gitlabci.plugin.ui.JobView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class JobSelectedListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GitLabCIPanel panel = GitLabCIPanel.getInstance();
        JobView jobView = (JobView) e.getSource();
        DefaultTableModel model = (DefaultTableModel) panel.getPropertiesTable().getModel();
        model.setRowCount(0);
        Map<String, String> properties = jobView.getJobParams();
        for (var property : properties.entrySet()) {
            model.addRow(new Object[]{property.getKey(), property.getValue()});
        }
    }
}
