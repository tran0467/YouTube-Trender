package youtubetrender;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class to run the GUI
 */
public class YouTubeTrenderFrame extends JFrame {
    Dimension frmWDim = new Dimension(10, 0);
    Dimension frmHDim = new Dimension(0, 10);
    Dimension smlVgap = new Dimension(0, 5);
    Dimension smlHgap = new Dimension(5, 0);

    List<YouTubeVideo> list = null;

    //DefaultListModel<WordItem> wmodel = new DefaultListModel();
    List<YouTubeWordItem> worldList;

    private JTextField jTextFieldDataFile;
    private JTextField jTextFieldSearch;
    private JTextField jTextFieldChannel;
    private JTextField jTextFieldDate;
    private JTextField jTextFieldTitle;
    private JTextArea jTextAreaDescription;
    private JTextField jTextFieldViewCount;
    private JTextField jTextFieldLikeCount;
    private JTextField jTextFieldDislikeCount;
    private JTextField jTextFieldCommentCount;
    private JList<YouTubeVideo> jListVideo;
    private DefaultListModel<YouTubeVideo> model;
    private YouTubeDataParser parser;
    private YouTubeVideoIndexer indexer;
    private JList<YouTubeWordItem> jListWord;
    private DefaultListModel<YouTubeWordItem> wordModel;
    private JComboBox combo;

    /**
     * Creates new form YouTubeTrenderFrame
     */
    public YouTubeTrenderFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(750, 500));
        setResizable(false);
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) { // feel free to change this as you see fit.
                    // Available: Nimbus, CDE, Metal, Windows...
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(YouTubeTrenderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(() -> new YouTubeTrenderFrame().setVisible(true));
    }

    /**
     * Create the main components on GUI
     */
    private void initComponents() {
        JPanel jpnlContainer = new JPanel();
        jpnlContainer.setLayout(new BoxLayout(jpnlContainer, BoxLayout.Y_AXIS));
        jpnlContainer.setBorder(new MatteBorder(10, 10, 10, 10, new Color(0, 107, 61)));
        jpnlContainer.add(Box.createRigidArea(frmHDim));
        jpnlContainer.add(createTopPanel());
        jpnlContainer.add(Box.createRigidArea(frmHDim));
        jpnlContainer.add(createSearchPanel());

        //create left Panel
        JPanel jpLeft = new JPanel();
        jpLeft.add(Box.createRigidArea(frmHDim));
        jpLeft.add(createTrendingPanel());

        //create right Panel
        JPanel jpRight = new JPanel();
        jpRight.setLayout(new BoxLayout(jpRight, BoxLayout.Y_AXIS));
        jpRight.add(Box.createRigidArea(frmHDim));
        jpRight.add(createSortingCriteria());
        jpRight.add(Box.createRigidArea(frmHDim));
        jpRight.add(createVideoPanel());

        //create combination Panel
        JPanel jpCombination = new JPanel();
        jpCombination.setLayout(new BoxLayout(jpCombination, BoxLayout.X_AXIS));
        jpCombination.add(jpLeft);
        jpRight.add(Box.createRigidArea(frmHDim));
        jpCombination.add(jpRight);

        jpnlContainer.add(jpCombination);
        jpnlContainer.add(Box.createRigidArea(frmHDim));
        jpnlContainer.add(createVideoDetailsPanel());

        add(jpnlContainer);

        pack();
    }

    /**
     * Create the Top panel
     * @return top panel
     */
    private JPanel createTopPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension(700, 25));
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        String[] fileList = {
                "YouTubeTrender/src/data/youtubedata.json",
                "YouTubeTrender/src/data/youtubedata_15_50.json",
                "YouTubeTrender/src/data/youtubedata_indextest.json",
                "YouTubeTrender/src/data/youtubedata_loremipsum.json",
                "YouTubeTrender/src/data/youtubedata_malformed.json"};
        combo = new JComboBox(fileList);

//        jTextFieldDataFile = new JTextField();
//        jTextFieldDataFile.setText("YouTubeTrender/src/data/youtubedata_15_50.json");

        //button Load
        JButton jButtonParse = new JButton();
        jButtonParse.setText("Load");
        jButtonParse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButtonParseActionPerformed(evt);
                } catch (YouTubeDataParserException e) {
                    e.printStackTrace();
                }
            }
        });

        //button Index
        JButton jIndex = new JButton();
        jIndex.setText("Index");
        jIndex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jIndexActionPerformed(evt);
                } catch (YouTubeDataParserException e) {
                    e.printStackTrace();
                }
            }
        });

//        jPanel.add(Box.createRigidArea(frmWDim));
//        jPanel.add(jTextFieldDataFile);
        jPanel.add(combo);
        jPanel.add(Box.createRigidArea(frmWDim));
        jPanel.add(jButtonParse);
        jPanel.add(Box.createRigidArea(frmWDim));
        jPanel.add(jIndex);

        return jPanel;
    }

    /**
     * create Search panel
     * @return search panel
     */
    private JPanel createSearchPanel() {
        JPanel jSearch = new JPanel();
        jSearch.setMaximumSize(new Dimension(700, 25));
        jSearch.setLayout(new BoxLayout(jSearch, BoxLayout.X_AXIS));
        jSearch.setBorder(BorderFactory.createTitledBorder("Search"));
        jTextFieldSearch = new JTextField();
        JButton jButtonSearch = new JButton();
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    jSearchActionPerformed(evt);
            }
        });

        jSearch.add(Box.createRigidArea(frmWDim));
        jSearch.add(jTextFieldSearch);
        jSearch.add(Box.createRigidArea(frmWDim));
        jSearch.add(jButtonSearch);

        return jSearch;
    }

    /**
     * create Trending panel
     * @return trending panel
     */
    private JPanel createTrendingPanel() {
        JPanel jTrending = new JPanel();
        jTrending.setMaximumSize(new Dimension(150, 200));
        jTrending.setPreferredSize(new Dimension(150, 200));
        jTrending.setLayout(new BoxLayout(jTrending, BoxLayout.Y_AXIS));
        jTrending.setBorder(BorderFactory.createTitledBorder("Trending"));

        JScrollPane jscrlpnListWord = new JScrollPane();
        jscrlpnListWord.setMaximumSize(new Dimension(120, 200));
        jscrlpnListWord.setPreferredSize(new Dimension(120, 200));
        wordModel = new DefaultListModel<>();
        jListWord = new JList<>(wordModel);
        jscrlpnListWord.setViewportView(jListWord);
        jListWord.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jSellectTrendingWorldActionPerformed(e);
            }
        });

        jTrending.add(jscrlpnListWord);
        return jTrending;
    }

    /**
     * create Sorting Criteria panel
     * @return Sorting Criteria panel
     */
    private JPanel createSortingCriteria() {
        JPanel js = new JPanel();
        js.setMaximumSize(new Dimension(550, 50));
        js.setPreferredSize(new Dimension(550, 50));
        js.setLayout(new BoxLayout(js, BoxLayout.X_AXIS));
        js.setBorder(BorderFactory.createTitledBorder("Sorting Criteria"));

        JRadioButton jr1 = new JRadioButton("Channel");
        jr1.setActionCommand("Channel");
        JRadioButton jr2 = new JRadioButton("Date");
        jr2.setActionCommand("Date");
        JRadioButton jr3 = new JRadioButton("View");
        jr3.setActionCommand("View");
        JRadioButton jr4 = new JRadioButton("Description");
        jr4.setActionCommand("Description");
        JRadioButton jr5 = new JRadioButton("Like");
        jr5.setActionCommand("Like");
        JRadioButton jr6 = new JRadioButton("Dislike");
        jr6.setActionCommand("Dislike");
        JRadioButton jr7 = new JRadioButton("Comment");
        jr7.setActionCommand("Comment");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jr1);
        buttonGroup.add(jr2);
        buttonGroup.add(jr3);
        buttonGroup.add(jr4);
        buttonGroup.add(jr5);
        buttonGroup.add(jr6);
        buttonGroup.add(jr7);

        jr1.addActionListener(new RadioButtonListener());
        jr2.addActionListener(new RadioButtonListener());
        jr3.addActionListener(new RadioButtonListener());
        jr4.addActionListener(new RadioButtonListener());
        jr5.addActionListener(new RadioButtonListener());
        jr6.addActionListener(new RadioButtonListener());
        jr7.addActionListener(new RadioButtonListener());

        js.add(Box.createRigidArea(frmHDim));
        js.add(jr1);
        js.add(jr2);
        js.add(jr3);
        js.add(jr4);
        js.add(jr5);
        js.add(jr6);
        js.add(jr7);
        return js;
    }

    /**
     * create video panel
     * @return video panel
     */
    private JPanel createVideoPanel() {
        JPanel jp = new JPanel();
        jp.setMaximumSize(new Dimension(550, 140));
        jp.setMinimumSize(new Dimension(550, 140));
        jp.setBorder(BorderFactory.createTitledBorder("Videos"));
        JScrollPane jscrlpnListVideo = new JScrollPane();
        jscrlpnListVideo.setPreferredSize(new Dimension(520, 110));
        model = new DefaultListModel<>();
        jListVideo = new JList<>(model);
        jscrlpnListVideo.setViewportView(jListVideo);
        jp.add(jscrlpnListVideo);
        jListVideo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jSellectListActionPerformed(e);
            }
        });
        return jp;
    }

    /**
     * create video details panel
     * @return video details panel
     */
    private JPanel createVideoDetailsPanel() {
        JPanel jp = new JPanel();
        jp.setMinimumSize(new Dimension(700, 300));
        jp.setPreferredSize(new Dimension(700, 300));
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.setBorder(BorderFactory.createTitledBorder("Video Details"));

        JPanel jpCombine = new JPanel();
        jpCombine.setLayout(new BoxLayout(jpCombine, BoxLayout.X_AXIS));

        JPanel jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));

        JPanel jp2 = new JPanel();
        jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));

        JPanel jp3 = new JPanel();

        JLabel jlblChannel = new JLabel("Channel");
        jTextFieldChannel = new JTextField();
        jTextFieldChannel.setEditable(false);
        JLabel jlblDate = new JLabel("Date Posted");
        jTextFieldDate = new JTextField();
        jTextFieldDate.setEditable(false);
        JLabel jlblTitle = new JLabel("Title");
        jTextFieldTitle = new JTextField();
        jTextFieldTitle.setEditable(false);
        JLabel jlblDescription = new JLabel("Description");
        JScrollPane jscrlpnAreaDescription = new JScrollPane();
        jTextAreaDescription = new JTextArea();
        jTextAreaDescription.setEditable(false);
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setWrapStyleWord(true);
        jscrlpnAreaDescription.setViewportView(jTextAreaDescription);
        JLabel jlblViewCount = new JLabel("View");
        jTextFieldViewCount = new JTextField();
        jTextFieldViewCount.setEditable(false);
        JLabel jlblCommentCount = new JLabel("Comment");
        jTextFieldCommentCount = new JTextField();
        jTextFieldCommentCount.setEditable(false);
        JLabel jlblLikeCount = new JLabel("Like");
        jTextFieldLikeCount = new JTextField();
        jTextFieldLikeCount.setEditable(false);
        JLabel jlblDislikeCount = new JLabel("Dislike");
        jTextFieldDislikeCount = new JTextField();
        jTextFieldDislikeCount.setEditable(false);

        JTextField jTextField = new JTextField(); // dummy to fill the gap
        jTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        jTextField.setEditable(false);


        jp.add(createHorizontalBox(jlblChannel, jTextFieldChannel));
        jp.add(createHorizontalBox(jlblDate, jTextFieldDate));
        jp.add(createHorizontalBox(jlblTitle, jTextFieldTitle));
        jp1.add(createHorizontalBox(jlblViewCount, jTextFieldViewCount));
        jp1.add(createHorizontalBox(jlblCommentCount, jTextFieldCommentCount));
        jp2.add(createHorizontalBox(jlblLikeCount, jTextFieldLikeCount));
        jp2.add(createHorizontalBox(jlblDislikeCount, jTextFieldDislikeCount));

        jpCombine.add(jp1);
        jpCombine.add(jp2);
        jp.add(jpCombine);
        jp.add(createHorizontalBox(jlblDescription, jTextField));
        Box descriptionTextBox = Box.createHorizontalBox();
        descriptionTextBox.setPreferredSize(new Dimension(650, 80));
        descriptionTextBox.add(jscrlpnAreaDescription);

        jp.add(descriptionTextBox);

        return jp;
    }

    /**
     * Convenience method to create a Horizontal Box
     *
     * @param jLabel     the label on the left of the box
     * @param jTextField the text field on the right of the box
     * @return the horizontal box
     */
    private Box createHorizontalBox(JLabel jLabel, JTextField jTextField) {
        Box b = Box.createHorizontalBox();
        b.setPreferredSize(new Dimension(650, 25));
        jLabel.setPreferredSize(new Dimension(100, 25));
        jLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        b.add(jLabel);
        b.add(Box.createRigidArea(smlHgap));
        b.add(jTextField);

        return b;
    }

    /**
     * Method to handle the event of pushing the "Load" button
     *
     * @param evt the Action Event associated with this button
     */
    private void jButtonParseActionPerformed(ActionEvent evt) throws YouTubeDataParserException {

//        String dataFile = jTextFieldDataFile.getText();
        String dataFile = String.valueOf(combo.getSelectedItem());
        parser = new YouTubeDataParser();
        list = null;
        model.removeAllElements();
        try {
            list = parser.parse(dataFile);
        } catch (YouTubeDataParserException ex) {
            //throw new YouTubeDataParserException("File not found: " + jTextFieldDataFile.getText());
            JOptionPane.showMessageDialog(null,
                    "File not found or malformed:" + dataFile,
                    "File not found",
                    JOptionPane.ERROR_MESSAGE);
        }


        if (list != null) {
            // YouTube data has been parsed successfully!
            // TODO: connect the list to the GUI
            for (YouTubeVideo a : list) {
                model.addElement(a);
            }
        }
    }

    /**
     * Method to handle the event of pushing the "Index" button
     *
     * @param evt the Action Event associated with this button
     */
    private void jIndexActionPerformed(ActionEvent evt) throws YouTubeDataParserException {

//        String dataFile = jTextFieldDataFile.getText();
        String dataFile = String.valueOf(combo.getSelectedItem());
        parser = new YouTubeDataParser();
        list = null;
        wordModel.removeAllElements();
        try {
            list = parser.parse(dataFile);
        } catch (YouTubeDataParserException ex) {
            //throw new YouTubeDataParserException("File not found: " + jTextFieldDataFile.getText());
            JOptionPane.showMessageDialog(null,
                    "File not found or malformed:" + dataFile,
                    "File not found",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (list != null){
        indexer = new YouTubeVideoIndexer(list);
        indexer.index();
        worldList = indexer.getSortedYouTubeWordItems();
            for (YouTubeWordItem a : worldList) {
                wordModel.addElement(a);
            }
        }
    }

    /**
     * Method to handle the event of selecting the video on list
     *
     * @param e the ListSelectionEvent associated with this selection
     */
    private void jSellectListActionPerformed(ListSelectionEvent e) {
        int selectedIndex = jListVideo.getSelectedIndex();
        if (selectedIndex > -1) {
            YouTubeVideo a = model.get(selectedIndex);
            jTextFieldChannel.setText(a.getChannel());
            jTextFieldDate.setText(a.getDate());
            jTextFieldTitle.setText(a.getTitle());
            jTextFieldViewCount.setText(String.valueOf(a.getViewCount()));
            jTextFieldLikeCount.setText(String.valueOf(a.getLikeCount()));
            jTextFieldDislikeCount.setText(String.valueOf(a.getDislikeCount()));
            jTextFieldCommentCount.setText(String.valueOf(a.getCommentCount()));
            jTextAreaDescription.setText(a.getDescription());
        }
    }

    /**
     * Method to handle the event of selecting the word on list
     *
     * @param e the ListSelectionEvent associated with this selection
     */
    private void jSellectTrendingWorldActionPerformed(ListSelectionEvent e) {
        int selectedIndex = jListWord.getSelectedIndex();
        if (selectedIndex > -1) {
            YouTubeWordItem a = wordModel.get(selectedIndex);
            model.removeAllElements();
            list.clear();
            for (YouTubeVideo b : a.getVideos()){
                list.add(b);
            }
            for(YouTubeVideo c : list){
                model.addElement(c);
            }
        }
    }


    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (list != null) {
                String choice = e.getActionCommand();

                if (choice == "Channel") {
                    list = parser.byChannel();
                } else if (choice == "Date") {
                    list = parser.byDate();
                } else if (choice == "View") {
                    list = parser.byView();
                } else if (choice == "Description") {
                    list = parser.byDescription();
                } else if (choice == "Like") {
                    list = parser.byLike();
                } else if (choice == "Dislike") {
                    list = parser.byDislike();
                } else if (choice == "Comment") {
                    list = parser.byComment();
                }

                model.removeAllElements();
                for (YouTubeVideo a : list) {
                    model.addElement(a);
                }
            }
        }
    }

    private void jSearchActionPerformed(ActionEvent evt) {
        String searchField = jTextFieldSearch.getText();

        model.removeAllElements();
        wordModel.removeAllElements();

        List<YouTubeVideo> searchVideo = new ArrayList<>();

        wordModel.addElement(indexer.getWordItem(searchField));

        for (YouTubeVideo t : indexer.getWordVideos(searchField)) {
            searchVideo.add(t);
        }

        for (YouTubeVideo a : searchVideo) {
            model.addElement(a);
        }
    }
}


