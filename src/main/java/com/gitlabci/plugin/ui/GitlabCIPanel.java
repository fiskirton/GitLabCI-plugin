package com.gitlabci.plugin.ui;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GitlabCIPanel extends SimpleToolWindowPanel {

    private static final GitlabCIPanel INSTANCE = new GitlabCIPanel();
    private final JPanel mainPanel;
    private final JBScrollPane previewPanelScroll;
    private final JBScrollPane propertiesPanelScroll;
    private final JPanel previewPanel;
    private JBTable propertiesTable;

    GitlabCIPanel() {
        super(true, false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));

        previewPanel = new JPanel();
        previewPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        previewPanel.setBorder(new LineBorder(JBColor.WHITE));

        DefaultTableModel model = new DefaultTableModel(0, 2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setColumnIdentifiers(new String[]{"key", "value"});
        propertiesTable = new JBTable(model);

        previewPanelScroll = new JBScrollPane(previewPanel, JBScrollPane.VERTICAL_SCROLLBAR_NEVER, JBScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        propertiesPanelScroll = new JBScrollPane(propertiesTable, JBScrollPane.VERTICAL_SCROLLBAR_NEVER, JBScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        mainPanel.add(previewPanelScroll);
        mainPanel.add(propertiesPanelScroll);

        ActionManager actionManager = ActionManager.getInstance();

        DefaultActionGroup actionGroup = new DefaultActionGroup("PreviewWindowGroup", false);
        actionGroup.add(actionManager.getAction("PipelinePreviewAction"));

        ActionToolbar toolbar = actionManager.createActionToolbar("PreviewWindowToolbar", actionGroup, true);
        toolbar.setTargetComponent(mainPanel);

        this.setToolbar(toolbar.getComponent());
        this.setContent(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JBScrollPane getPreviewPanelScroll() {
        return previewPanelScroll;
    }

    public JPanel getPreviewPanel() {
        return previewPanel;
    }

    public JBScrollPane getPropertiesPanelScroll() {
        return propertiesPanelScroll;
    }

    public JBTable getPropertiesTable() {
        return propertiesTable;
    }

    public static GitlabCIPanel getInstance() {
        return INSTANCE;
    }
}