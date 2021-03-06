package studio.rashka.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import studio.rashka.History;

public class Questions {

    private Map<String, ImageButton> buttons;
    private ImageButtonStyle buttonStyle;
    private StringBuilder NameQuestion, V1, V2, V3, V4, help1, help50, helpTrue, infoText;
    private int index, indeX; // загружаем данные по номеру вопроса
    private static int N; // количество вопросов для заполнения массива q[]
    private int q[];
    private Random random;
    private boolean trueV1 = true, trueV2 = true, trueV3 = true, trueV4 = true;

    private QuestionName questionName;
    private Question1 question1;
    private Question2 question2;
    private Question3 question3;
    private Question4 question4;
    private QuestionTrue questionTrue;
    private QuestionShowTrue questionShowTrue;

    public Questions() {
        questionName = new QuestionName();
        question1 = new Question1();
        question2 = new Question2();
        question3 = new Question3();
        question4 = new Question4();
        questionTrue = new QuestionTrue();
        questionShowTrue = new QuestionShowTrue();
        random = new Random();

        buttonStyle = new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("NONE"), History.getTextures().getAtlasTextureSkin().getDrawable("NONE_03"), null, null, null, null);
        buttons = new HashMap<String, ImageButton>();

        N = History.getRunTest().getQ_all() + 1;
        onALL_1();
    }

    public void onALL_1() {
        q = new int[N];
        for (int i = 0; i <= History.getRunTest().getQ_all(); i++) {
            q[i] = 1;
        }
    }

    public void onQuestion(int i) {
        //Gdx.app.log("", "" + i + " - " + History.getNomerTesta());
        trueV1 = true;
        trueV2 = true;
        trueV3 = true;
        trueV4 = true;

        History.getTime().setTime(31);

        if (i > 0) this.indeX = i-1;
        else if (i == 0) this.indeX = i;
        this.index = i;

        if (q[i] == 1 && i < History.getRunTest().getQ_all()) { onStartQ(); q[i] = 0; }
        else if (q[i] == 0 && i < History.getRunTest().getQ_all()) onQuestion(i+1);
        else if (i >= History.getRunTest().getQ_all()) onQuestion(1);
    }

    private void buttonsHelp() {
        buttons.get("Remove").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Remove").setPosition(256 * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("Remove").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadHelpRemove() > 0 && History.getRunTest().isOn1()) {
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.getPreference().saveHelpRemove(0, 1);
                    help1 = new StringBuilder().append(History.getPreference().loadHelpRemove());
                    switch (random.nextInt(4)) {
                        case 0:
                            if (questionTrue.QT[indeX] != 1) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV1 = false;
                            }
                            else if (questionTrue.QT[indeX] == 1) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV2 = false;
                            }
                            break;
                        case 1:
                            if (questionTrue.QT[indeX] != 2) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV2 = false;
                            }
                            else if (questionTrue.QT[indeX] == 2) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV3 = false;
                            }
                            break;
                        case 2:
                            if (questionTrue.QT[indeX] != 3) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV3 = false;
                            }
                            else if (questionTrue.QT[indeX] == 3) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV4 = false;
                            }
                            break;
                        case 3:
                            if (questionTrue.QT[indeX] != 4) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV4 = false;
                            }
                            else if (questionTrue.QT[indeX] == 4) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV1 = false;
                            }
                    }
                }
                else if (History.getPreference().loadHelpRemove() <= 0) {
                    help1 = new StringBuilder().append(History.getPreference().loadHelpRemove());
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.adHandler.showAds(0);
                    History.getPreference().saveTimeRun(false);
                }
            }
        });

        buttons.get("5050").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("5050").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), (History.HEIGHT - 340) * History.getRatioMonitorH());
        buttons.get("5050").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadHelp50() > 0 && History.getRunTest().isOn50()) {
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.getPreference().saveHelp50(0, 1);
                    help50 = new StringBuilder().append(History.getPreference().loadHelp50());
                    int a = random.nextInt(4);
                    int b = random.nextInt(4);
                    if (b == a) {
                        for (int i = 0; i < 100; i++) {
                            b = random.nextInt(4);
                            if (b != a) break;
                        }
                    }
                    switch (a) {
                        case 0:
                            if (questionTrue.QT[indeX] != 1) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV1 = false;
                            }
                            else if (questionTrue.QT[indeX] == 1) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV2 = false;
                            }
                            break;
                        case 1:
                            if (questionTrue.QT[indeX] != 2) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV2 = false;
                            }
                            else if (questionTrue.QT[indeX] == 2) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV3 = false;
                            }
                            break;
                        case 2:
                            if (questionTrue.QT[indeX] != 3) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV3 = false;
                            }
                            else if (questionTrue.QT[indeX] == 3) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV4 = false;
                            }
                            break;
                        case 3:
                            if (questionTrue.QT[indeX] != 4) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV4 = false;
                            }
                            else if (questionTrue.QT[indeX] == 4) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV1 = false;
                            }
                    }
                    switch (b) {
                        case 0:
                            if (questionTrue.QT[indeX] != 1 && trueV1) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV1 = false;
                            }
                            else if (questionTrue.QT[indeX] != 1 && !trueV1) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                trueV2 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            else if (questionTrue.QT[indeX] == 1) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                trueV2 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            break;
                        case 1:
                            if (questionTrue.QT[indeX] != 2 && trueV2) {
                                History.getRunTest().onStageNewDeleteText();
                                V2 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV2 = false;
                            }
                            else if (questionTrue.QT[indeX] != 2 && !trueV2) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                trueV3 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            else if (questionTrue.QT[indeX] == 2) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                trueV3 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            break;
                        case 2:
                            if (questionTrue.QT[indeX] != 3 && trueV3) {
                                History.getRunTest().onStageNewDeleteText();
                                V3 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV3 = false;
                            }
                            else if (questionTrue.QT[indeX] != 3 && !trueV3) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                trueV4 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            else if (questionTrue.QT[indeX] == 3) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                trueV4 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            break;
                        case 3:
                            if (questionTrue.QT[indeX] != 4 && trueV4) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                                trueV4 = false;
                            }
                            else if (questionTrue.QT[indeX] != 4 && !trueV4) {
                                History.getRunTest().onStageNewDeleteText();
                                V4 = new StringBuilder("");
                                trueV4 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                            else if (questionTrue.QT[indeX] == 4) {
                                History.getRunTest().onStageNewDeleteText();
                                V1 = new StringBuilder("");
                                trueV1 = false;
                                History.getRunTest().repeatText();
                                History.getRunTest().setOn1(false);
                                History.getRunTest().setOn50(false);
                            }
                    }
                }
                else if (History.getPreference().loadHelp50() <= 0) {
                    help50 = new StringBuilder().append(History.getPreference().loadHelp50());
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.adHandler.showAds(1);
                    History.getPreference().saveTimeRun(false);
                }
            }
        });

        buttons.get("True").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("True").setPosition((History.WIDTH - 384) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("True").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadHelpTrue() > 0 && History.getRunTest().isOnTrue()) {
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.getPreference().saveHelpTrue(0, 1);
                    helpTrue = new StringBuilder().append(History.getPreference().loadHelpTrue());
                    if (random.nextInt(100) < 80) {
                        if (questionTrue.QT[indeX] == 1) {
                            History.getRunTest().onStageNewDeleteText();
                            if (trueV1) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                            else if (!trueV1) {
                                if (trueV2) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                                else if (!trueV2) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                            }
                            History.getRunTest().repeatText();
                            History.getRunTest().setOnTrue(false);
                        } else if (questionTrue.QT[indeX] == 2) {
                            History.getRunTest().onStageNewDeleteText();
                            if (trueV2) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                            else if (!trueV2) {
                                if (trueV3) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                                else if (!trueV3) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                            }
                            History.getRunTest().repeatText();
                            History.getRunTest().setOnTrue(false);
                        } else if (questionTrue.QT[indeX] == 3) {
                            History.getRunTest().onStageNewDeleteText();
                            if (trueV3) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                            else if (!trueV3) {
                                if (trueV4) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                                else if (!trueV4) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                            }
                            History.getRunTest().repeatText();
                            History.getRunTest().setOnTrue(false);
                        } else if (questionTrue.QT[indeX] == 4) {
                            History.getRunTest().onStageNewDeleteText();
                            if (trueV4) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                            else if (!trueV4) {
                                if (trueV1) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                                else if (!trueV1) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                            }
                            History.getRunTest().repeatText();
                            History.getRunTest().setOnTrue(false);
                        }
                    }
                    else {
                        switch (random.nextInt(4)) {
                            case 0:
                                History.getRunTest().onStageNewDeleteText();
                                if (trueV1) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                                else if (!trueV1) {
                                    if (trueV2) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                                    else if (!trueV2) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                                }
                                History.getRunTest().repeatText();
                                History.getRunTest().setOnTrue(false);
                                break;
                            case 1:
                                History.getRunTest().onStageNewDeleteText();
                                if (trueV2) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                                else if (!trueV2) {
                                    if (trueV3) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                                    else if (!trueV3) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                                }
                                History.getRunTest().repeatText();
                                History.getRunTest().setOnTrue(false);
                                break;
                            case 2:
                                History.getRunTest().onStageNewDeleteText();
                                if (trueV3) V3 = new StringBuilder().append("> ").append(question3.V3[indeX]).append(" <");
                                else if (!trueV3) {
                                    if (trueV4) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                                    else if (!trueV4) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                                }
                                History.getRunTest().repeatText();
                                History.getRunTest().setOnTrue(false);
                                break;
                            case 3:
                                History.getRunTest().onStageNewDeleteText();
                                if (trueV4) V4 = new StringBuilder().append("> ").append(question4.V4[indeX]).append(" <");
                                else if (!trueV4) {
                                    if (trueV1) V1 = new StringBuilder().append("> ").append(question1.V1[indeX]).append(" <");
                                    else if (!trueV1) V2 = new StringBuilder().append("> ").append(question2.V2[indeX]).append(" <");
                                }
                                History.getRunTest().repeatText();
                                History.getRunTest().setOnTrue(false);
                                break;
                        }
                    }
                }
                else if (History.getPreference().loadHelpTrue() <= 0) {
                    helpTrue = new StringBuilder().append(History.getPreference().loadHelpTrue());
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    History.adHandler.showAds(2);
                    History.getPreference().saveTimeRun(false);
                }
            }
        });
    }

    private void onStartQ() {
        History.getPreference().saveTimeRun(true);
        History.getRunTest().setOn1(true);
        History.getRunTest().setOn50(true);
        History.getRunTest().setOnTrue(true);

        buttons.put("btn_v1", new ImageButton(buttonStyle));
        buttons.put("btn_v2", new ImageButton(buttonStyle));
        buttons.put("btn_v3", new ImageButton(buttonStyle));
        buttons.put("btn_v4", new ImageButton(buttonStyle));

        buttons.put("Remove", new ImageButton(buttonStyle));
        buttons.put("5050", new ImageButton(buttonStyle));
        buttons.put("True", new ImageButton(buttonStyle));

        buttons.put("Exit_small", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Exit_small"),null, null, null, null, null)));

        NameQuestion = questionName.Name[indeX];
        V1 = question1.V1[indeX];
        V2 = question2.V2[indeX];
        V3 = question3.V3[indeX];
        V4 = question4.V4[indeX];

        if (index == 7 || index == 8 || index == 9 || index == 11 || index == 18 || index == 22 || index == 23 || index == 29 ||
                index == 30 || index == 31 || index == 32 || index == 35 || index == 36 || index == 37 || index == 38 ||
                index == 41 || index == 45 || index == 48 || index == 50 || index == 51 || index == 53 || index == 58 ||
                index == 59 || index == 61 || index == 63 || index == 69 || index == 71 || index == 72 || index == 73 ||
                index == 74 || index == 75 || index == 76 || index == 77 || index == 79 || index == 80 || index == 83 ||
                index == 88 || index == 95 || index == 96 || index == 109 || index == 114 || index == 117 || index == 118 ||
                index == 128 || index == 142 || index == 143 || index == 144 || index == 145 || index == 159 || index == 161 ||
                index == 162 || index == 163 || index == 164 || index == 185 || index == 190 || index == 191 || index == 196 ||
                index == 198 || index == 204 || index == 205 || index == 206 || index == 207 || index == 216 || index == 217 ||
                index == 221 || index == 224 || index == 230 || index == 236 || index == 239 || index == 240 || index == 247 ||
                index == 248 || index == 264 || index == 274 || index == 275 || index == 282 || index == 292 || index == 293 ||
                index == 294 || index == 304 || index == 306 || index == 317 || index == 320 || index == 324 || index == 325 ||
                index == 330) {
            History.getRunTest().setYq(0); // одна строчка
            History.getRunTest().setHq(0);
            History.getRunTest().setXq(50);
        }
        else if (index == 0 || index == 1 || index == 2 || index == 3 || index == 4 || index == 5 || index == 10 || index == 12 ||
                index == 13 || index == 14 || index == 15 || index == 17 || index == 19 || index == 20 || index == 21 ||
                index == 24 || index == 25 || index == 26 || index == 27 || index == 28 || index == 33 || index == 34 ||
                index == 39 || index == 40 || index == 43 || index == 44 || index == 46 || index == 47 || index == 52 ||
                index == 54 || index == 55 || index == 56 || index == 57 || index == 64 || index == 65 || index == 66 ||
                index == 70 || index == 81 || index == 84 || index == 87 || index == 90 || index == 92 || index == 94 ||
                index == 100 || index == 102 || index == 105 || index == 106 || index == 107 || index == 108 || index == 110 ||
                index == 111 || index == 116 || index == 119 || index == 120 || index == 121 || index == 122 || index == 123 ||
                index == 124 || index == 125 || index == 126 || index == 127 || index == 129 || index == 133 || index == 134 ||
                index == 135 || index == 137 || index == 138 || index == 140 || index == 141 || index == 146 || index == 147 ||
                index == 148 || index == 149 || index == 150 || index == 151 || index == 152 || index == 153 || index == 154 ||
                index == 155 || index == 156 || index == 165 || index == 166 || index == 167 || index == 168 || index == 169 ||
                index == 170 || index == 171 || index == 172 || index == 173 || index == 174 || index == 175 || index == 176 ||
                index == 177 || index == 178 || index == 180 || index == 181 || index == 182 || index == 183 || index == 184 ||
                index == 186 || index == 188 || index == 189 || index == 192 || index == 194 || index == 195 || index == 197 ||
                index == 199 || index == 200 || index == 201 || index == 208 || index == 209 || index == 215 || index == 218 ||
                index == 220 || index == 222 || index == 225 || index == 226 || index == 231 || index == 233 || index == 235 ||
                index == 241 || index == 243 || index == 245 || index == 249 || index == 250 || index == 251 || index == 252 ||
                index == 253 || index == 254 || index == 255 || index == 256 || index == 257 || index == 258 || index == 259 ||
                index == 260 || index == 261 || index == 262 || index == 263 || index == 265 || index == 267 || index == 268 ||
                index == 269 || index == 270 || index == 271 || index == 272 || index == 273 || index == 276 || index == 277 ||
                index == 278 || index == 279 || index == 280 || index == 281 || index == 284 || index == 285 || index == 286 ||
                index == 290 || index == 291 || index == 296 || index == 297 || index == 298 || index == 299 || index == 301 ||
                index == 303 || index == 305 || index == 307 || index == 308 || index == 309 || index == 310 || index == 312 ||
                index == 315 || index == 316 || index == 319 || index == 321 || index == 322 || index == 323 || index == 327 ||
                index == 328 || index == 331 || index == 332 || index == 333 || index == 334 || index == 335 || index == 336 ||
                index == 337 || index == 338 || index == 339 || index == 340 || index == 341 || index == 342 || index == 343) {
            History.getRunTest().setYq(0); // две строчки
            History.getRunTest().setHq(0);
            History.getRunTest().setXq(27);
        }
        else if (index == 6 || index == 16 || index == 49 || index == 60 || index == 62 || index == 68 || index == 78 || index == 82 ||
                index == 85 || index == 86 || index == 91 || index == 93 || index == 101 || index == 104 || index == 112 || index == 130 ||
                index == 131 || index == 132 || index == 136 || index == 139 || index == 157 || index == 158 || index == 160 ||
                index == 187 || index == 193 || index == 202 || index == 203 || index == 210 || index == 211 || index == 212 ||
                index == 213 || index == 214 || index == 219 || index == 227 || index == 228 || index == 229 || index == 232 ||
                index == 234 || index == 237 || index == 238 || index == 242 || index == 244 || index == 246 || index == 266 ||
                index == 283 || index == 288 || index == 289 || index == 295 || index == 300 || index == 302 || index == 311 ||
                index == 313 || index == 314 || index == 318 || index == 329 || index == 344 || index == 345) {
            History.getRunTest().setYq(11); // три строчки
            History.getRunTest().setHq(46);
            History.getRunTest().setXq(20);
        }
        else if (index == 42 || index == 67 || index == 97 || index == 98 || index == 99 || index == 103 || index == 113 || index == 179 ||
                index == 223 || index == 287 || index == 326) {
            History.getRunTest().setYq(0); // четыре строчки
            History.getRunTest().setHq(90);
            History.getRunTest().setXq(14);
        }
        else if (index == 89 || index == 115) {
            History.getRunTest().setYq(80); // пять строк
            History.getRunTest().setHq(140);
            History.getRunTest().setXq(14);
        }

        buttons.get("btn_v1").setSize(704 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("btn_v1").setPosition((History.WIDTH / 2 - 704 / 2) * History.getRatioMonitorW(), 830 * History.getRatioMonitorH());
        buttons.get("btn_v1").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(History.getNomerTesta() + 1);
                if (questionTrue.QT[indeX] == 1) {
                    History.setPravilno(History.getPravilno() + 1); // если правильно
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().onTest(random.nextInt(History.getRunTest().getQ_all()));
                }
                else if (questionTrue.QT[indeX] != 1) {
                    int i = 0;
                    History.getRunTest().setShowTrue(true);
                    if (questionTrue.QT[indeX] == 2) V1 = question2.V2[indeX];
                    else if (questionTrue.QT[indeX] == 3) V1 = question3.V3[indeX];
                    else if (questionTrue.QT[indeX] == 4) V1 = question4.V4[indeX];
                    infoText = questionShowTrue.Name[indeX];
                    while (i + 37 < infoText.length() && (i = infoText.lastIndexOf(" ", i + 37)) != -1) infoText.replace(i, i + 1, "\n");
                    V2 = infoText;
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().showInfoTrue();
                }
            }
        });

        buttons.get("btn_v2").setSize(704 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("btn_v2").setPosition((History.WIDTH / 2 - 704 / 2) * History.getRatioMonitorW(), 638 * History.getRatioMonitorH());
        buttons.get("btn_v2").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(History.getNomerTesta() + 1);
                if (questionTrue.QT[indeX] == 2) {
                    History.setPravilno(History.getPravilno() + 1); // если правильно
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().onTest(random.nextInt(History.getRunTest().getQ_all()));
                }
                else if (questionTrue.QT[indeX] != 2) {
                    int i = 0;
                    History.getRunTest().setShowTrue(true);
                    if (questionTrue.QT[indeX] == 1) V1 = question1.V1[indeX];
                    else if (questionTrue.QT[indeX] == 3) V1 = question3.V3[indeX];
                    else if (questionTrue.QT[indeX] == 4) V1 = question4.V4[indeX];
                    infoText = questionShowTrue.Name[indeX];
                    while (i + 37 < infoText.length() && (i = infoText.lastIndexOf(" ", i + 37)) != -1) infoText.replace(i, i + 1, "\n");
                    V2 = infoText;
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().showInfoTrue();
                }
            }
        });

        buttons.get("btn_v3").setSize(704 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("btn_v3").setPosition((History.WIDTH / 2 - 704 / 2) * History.getRatioMonitorW(), 446 * History.getRatioMonitorH());
        buttons.get("btn_v3").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(History.getNomerTesta() + 1);
                if (questionTrue.QT[indeX] == 3) {
                    History.setPravilno(History.getPravilno() + 1); // если правильно
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().onTest(random.nextInt(History.getRunTest().getQ_all()));
                }
                else if (questionTrue.QT[indeX] != 3) {
                    int i = 0;
                    History.getRunTest().setShowTrue(true);
                    if (questionTrue.QT[indeX] == 1) V1 = question1.V1[indeX];
                    else if (questionTrue.QT[indeX] == 2) V1 = question2.V2[indeX];
                    else if (questionTrue.QT[indeX] == 4) V1 = question4.V4[indeX];
                    infoText = questionShowTrue.Name[indeX];
                    while (i + 37 < infoText.length() && (i = infoText.lastIndexOf(" ", i + 37)) != -1) infoText.replace(i, i + 1, "\n");
                    V2 = infoText;
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().showInfoTrue();
                }
            }
        });

        buttons.get("btn_v4").setSize(704 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("btn_v4").setPosition((History.WIDTH / 2 - 704 / 2) * History.getRatioMonitorW(), 254 * History.getRatioMonitorH());
        buttons.get("btn_v4").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(History.getNomerTesta() + 1);
                if (questionTrue.QT[indeX] == 4) {
                    History.setPravilno(History.getPravilno() + 1); // если правильно
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().onTest(random.nextInt(History.getRunTest().getQ_all()));
                }
                else if (questionTrue.QT[indeX] != 4) {
                    int i = 0;
                    History.getRunTest().setShowTrue(true);
                    if (questionTrue.QT[indeX] == 1) V1 = question1.V1[indeX];
                    else if (questionTrue.QT[indeX] == 2) V1 = question2.V2[indeX];
                    else if (questionTrue.QT[indeX] == 3) V1 = question3.V3[indeX];
                    infoText = questionShowTrue.Name[indeX];
                    while (i + 37 < infoText.length() && (i = infoText.lastIndexOf(" ", i + 37)) != -1) infoText.replace(i, i + 1, "\n");
                    V2 = infoText;
                    History.getRunTest().onStageNewDelete();
                    History.getRunTest().showInfoTrue();
                }
            }
        });

        buttons.get("Exit_small").setSize(128 * History.getRatioMonitorW(), 77 * History.getRatioMonitorH());
        buttons.get("Exit_small").setPosition((History.WIDTH - 128) * History.getRatioMonitorW(), 22 * History.getRatioMonitorH());
        buttons.get("Exit_small").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.app.exit();
            }
        });

        buttonsHelp();
        History.getRunTest().onAddActor();
    }

    public StringBuilder getNameQuestion() {
        return NameQuestion;
    }

    public StringBuilder getV1() {
        return V1;
    }

    public StringBuilder getV2() {
        return V2;
    }

    public StringBuilder getV3() {
        return V3;
    }

    public StringBuilder getV4() {
        return V4;
    }

    public ImageButton getBtn_v1() {
        return buttons.get("btn_v1");
    }

    public ImageButton getBtn_v2() {
        return buttons.get("btn_v2");
    }

    public ImageButton getBtn_v3() {
        return buttons.get("btn_v3");
    }

    public ImageButton getBtn_v4() {
        return buttons.get("btn_v4");
    }

    public ImageButton getBtn_Remove() {
        return buttons.get("Remove");
    }

    public ImageButton getBtn_5050() {
        return buttons.get("5050");
    }

    public ImageButton getBtn_True() {
        return buttons.get("True");
    }

    public ImageButton getBtn_Exit() {
        return buttons.get("Exit_small");
    }

    public void dispose() {
        try {
            buttons.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}