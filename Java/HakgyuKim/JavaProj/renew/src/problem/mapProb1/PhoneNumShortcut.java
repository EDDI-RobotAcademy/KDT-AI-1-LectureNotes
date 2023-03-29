package problem.mapProb1;

import java.util.HashMap;
import java.util.Map;

class PhoneNumShortcutMap {
    private Map<Integer, Integer> phoneNumInfo = new HashMap<>();

    public void setPhoneNumShortcut(int phoneNum, int shortcut) {
        phoneNumInfo.put(phoneNum, shortcut);
    }

    public int getPhoneNumShortcut (int phoneNum) {
        return phoneNumInfo.get(phoneNum);
    }

}

public class PhoneNumShortcut {
    public static void main(String[] args) {
        PhoneNumShortcutMap phoneNumShortcut = new PhoneNumShortcutMap();
        final int phoneNum1 = 11111111;
        final int phoneNum2 = 22222222;
        final int shortcut1 = 1;
        final int shortcut2 = 2;
        phoneNumShortcut.setPhoneNumShortcut(phoneNum1,shortcut1);
        phoneNumShortcut.setPhoneNumShortcut(phoneNum2,shortcut2);

        System.out.println(phoneNum1 + " 의 단축키는: " +
                phoneNumShortcut.getPhoneNumShortcut(phoneNum1));
        System.out.println(phoneNum2 + " 의 단축키는: " +
                phoneNumShortcut.getPhoneNumShortcut(phoneNum2));
        System.out.println(phoneNumShortcut);
    }


}
