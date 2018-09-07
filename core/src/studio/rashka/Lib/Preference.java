package studio.rashka.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Preference {

    private Preferences setting;
    private byte outlaw = 0, slave = 0, peasant = 0, volunteer = 0, feudal = 0, prince = 0,
            in = 0, all = 0, trueOtvet = 0, stability = 0, like = 0;

    public Preference() {
        setting = Gdx.app.getPreferences("Pref_app"); // настройки приложения
        //setting.clear(); // если изменили тип данных, то разкомментировать, запускаем и комментируем обратно, т.е. обнуляем всё

        boolean start_pref = setting.getBoolean("Start_Pref");
        boolean startHelpBonus = setting.getBoolean("HelpBonus");
        if (!startHelpBonus) {
            setting.putInteger("HelpRemove", 5);
            setting.putInteger("Help50", 5);
            setting.putInteger("HelpTrue", 5);
            setting.putBoolean("HelpBonus", true); // сообщаем, что уже получены бонусы
            setting.flush();
        }
        if (!start_pref) { // если запускается в первые, то запускаем параметры по умолчанию
            saveSound(1);
            saveMusic(1);
            setting.putInteger("Min", 20); // минимальный балл
            setting.putInteger("Max", 0); // максимальный балл
            setting.putInteger("Last", 0); // баллов за последний тест
            setting.putInteger("All", 0); // всего пройдено тестов
            setting.putInteger("True", 0); // верных ответов
            setting.putInteger("BestBattle", 0);
            setting.putInteger("Victory", 0);
            setting.putInteger("Defeat", 0);
            //saveLanguage(0);
            setting.putBoolean("Start_Pref", true); // сообщаем, что приложение уже было запущено
            setting.flush();
        }
    }

    public int width() {
        return setting.getInteger("Width");
    }

    public int height() {
        return setting.getInteger("Height");
    }

    public void saveSound(int on_off) { // сохраняем настройки звуков
        setting.putInteger("Sound", on_off);
        setting.flush();
    }

    public int loadSound() { // загружаем настройки звуков
        return setting.getInteger("Sound");
    }

    public void saveMusic(int on_off) { // сохраняем настройки музыки
        setting.putInteger("Music", on_off);
        setting.flush();
    }

    public boolean loadTimeRun() {
        return setting.getBoolean("RunTime");
    }

    public void saveTimeRun(boolean run) {
        setting.putBoolean("RunTime", run);
        setting.flush();
    }

    public boolean loadBonus() {
        return setting.getBoolean("Bonus");
    }

    public void setBonus(boolean bonus) {
        setting.putBoolean("Bonus", bonus);
        setting.flush();
    }

    public void setBestBattle(int battle) {
        setting.putInteger("BestBattle", battle);
        setting.flush();
    }

    public int getBestBattle() {
        return setting.getInteger("BestBattle");
    }

    public void setVictory(int battle, boolean add) {
        if (add) setting.putInteger("Victory", setting.getInteger("Victory") + battle);
        else setting.putInteger("Victory", battle);
        setting.flush();
    }

    public int getVictory() {
        return setting.getInteger("Victory");
    }

    public void setDefeat(int battle, boolean add) {
        if (add) setting.putInteger("Defeat", setting.getInteger("Defeat") + battle);
        else setting.putInteger("Defeat", battle);
        setting.flush();
    }

    public int getDefeat() {
        return setting.getInteger("Defeat");
    }

    /***** Подсказки *****/

    public int loadHelpRemove() {
        return setting.getInteger("HelpRemove");
    }

    public void saveHelpRemove(int plus, int minus) {
        setting.putInteger("HelpRemove", loadHelpRemove() + plus - minus);
        setting.flush();
    }

    public int loadHelp50() {
        return setting.getInteger("Help50");
    }

    public void saveHelp50(int plus, int minus) {
        setting.putInteger("Help50", loadHelp50() + plus - minus);
        setting.flush();
    }

    public int loadHelpTrue() {
        return setting.getInteger("HelpTrue");
    }

    public void saveHelpTrue(int plus, int minus) {
        setting.putInteger("HelpTrue", loadHelpTrue() + plus - minus);
        setting.flush();
    }

    /***** МИНИМУМ *****/

    public int loadMin() {
        return setting.getInteger("Min");
    }

    public void saveMin(int min) {
        if (loadMin() > min) {
            setting.putInteger("Min", min);
            setting.flush();
        }
        else if (min == 0) {
            setting.putInteger("Min", min);
            setting.flush();
        }
    }

    /***** МАКСИМУМ *****/

    public int loadMax() {
        return setting.getInteger("Max");
    }

    public void saveMax(int max) {
        if (loadMax() < max) {
            setting.putInteger("Max", max);
            setting.flush();
        }
        else if (max == 20) {
            setting.putInteger("Max", max);
            setting.flush();
        }
    }

    /***** ПОСЛЕДНИЙ *****/

    public int loadLast() {
        return setting.getInteger("Last");
    }

    public void saveLast(int last) {
        setting.putInteger("Last", last);
        setting.flush();
    }

    /***** ВСЕГО *****/

    public int loadAll() {
        return setting.getInteger("All");
    }

    public void saveAll(int all) {
        setting.putInteger("All", loadAll() + all);
        setting.flush();
    }

    /***** ВСЕГО ВЕРНЫХ ОТВЕТОВ *****/

    public int loadTrue() {
        return setting.getInteger("True");
    }

    public void saveTrue(int True) {
        setting.putInteger("True", loadTrue() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ИЗГОЙ *****/

    public int loadOutlaw() {
        return setting.getInteger("Outlaw");
    }

    public void saveOutlaw(int True) {
        setting.putInteger("Outlaw", loadOutlaw() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ РАБ *****/

    public int loadSlave() {
        return setting.getInteger("Slave");
    }

    public void saveSlave(int True) {
        setting.putInteger("Slave", loadSlave() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ КРЕСТЬЯНИН *****/

    public int loadPeasant() {
        return setting.getInteger("Peasant");
    }

    public void savePeasant(int True) {
        setting.putInteger("Peasant", loadPeasant() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ВОИН *****/

    public int loadVolunteer() {
        return setting.getInteger("Volunteer");
    }

    public void saveVolunteer(int True) {
        setting.putInteger("Volunteer", loadVolunteer() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ФЕОДАЛ *****/

    public int loadFeudal() {
        return setting.getInteger("Feudal");
    }

    public void saveFeudal(int True) {
        setting.putInteger("Feudal", loadFeudal() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ КНЯЗЬ *****/

    public int loadPrince() {
        return setting.getInteger("Prince");
    }

    public void savePrince(int True) {
        setting.putInteger("Prince", loadPrince() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ЗАПУСК ИГРЫ *****/

    public int loadIn() {
        return setting.getInteger("In");
    }

    public void saveIn(int True) {
        setting.putInteger("In", loadIn() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ПРОЦЕНТ ВЕРНЫХ ОТВЕТОВ *****/

    public int loadTrueOtvet() {
		if (loadTrue() != 0 && loadAll() != 0) return (loadTrue() / (loadAll() * 20)) * 100;
		else return 0;
    }

    /***** ДОСТИЖЕНИЕ СТАБИЛЬНОСТЬ - 4 подряд одиннаковых результата *****/

    public int loadStability() {
        return setting.getInteger("Stability");
    }

    public void saveStability(int True) {
        int x;
        if (True == 5) x = True;
        else if (loadTrue() == True) x = loadStability() + 1;
        else x = 0;
        setting.putInteger("Stability", x);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ОЦЕНКА ПРИЛОЖЕНИЯ *****/

    public int loadLike() {
        return setting.getInteger("Like");
    }

    public void saveLike(int True) {
        setting.putInteger("Like", loadLike() + True);
        setting.flush();
    }

    /***** ДОСТИЖЕНИЕ ВСЁ ОТКРЫТО *****/

    public int loadAllAch() {
        return setting.getInteger("AllAch");
    }

    public void saveAllAch() {
        int x;
        x = outlaw + slave + peasant + volunteer + feudal + prince + in + all + trueOtvet + stability + like;
        setting.putInteger("AllAch", x);
        setting.flush();
    }

    public int loadMusic() { // загружаем настройки музыки
        return setting.getInteger("Music");
    }

    public void setOutlaw(byte outlaw) {
        this.outlaw = outlaw;
    }

    public void setSlave(byte slave) {
        this.slave = slave;
    }

    public void setPeasant(byte peasant) {
        this.peasant = peasant;
    }

    public void setVolunteer(byte volunteer) {
        this.volunteer = volunteer;
    }

    public void setFeudal(byte feudal) {
        this.feudal = feudal;
    }

    public void setPrince(byte prince) {
        this.prince = prince;
    }

    public void setIn(byte in) {
        this.in = in;
    }

    public void setAll(byte all) {
        this.all = all;
    }

    public void setTrueOtvet(byte trueOtvet) {
        this.trueOtvet = trueOtvet;
    }

    public void setStability(byte stability) {
        this.stability = stability;
    }

    public void setLike(byte like) {
        this.like = like;
    }
}