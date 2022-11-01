package newjwglxt.jwglxt.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @description: 快捷button
 * @author: jee
 */
public class QuickButton {
    /**
     * 白字蓝底无边框
     *
     * @param text
     * @return
     */
    public static JButton primaryButton(String text) {
        return createBgButton(text, PRIMARY_BG, FONT_COLOR);
    }

    /**
     * 白字红底无边框
     *
     * @param text
     * @return
     */
    public static JButton dangerButton(String text) {
        return createBgButton(text, DANGER_BG, FONT_COLOR);
    }

    /**
     * 白字绿底无边框
     *
     * @param text
     * @return
     */
    public static JButton greenButton(String text) {
        return createBgButton(text, GREEN_BG, FONT_COLOR);
    }

    /**
     * 蓝字蓝边框透明背景
     *
     * @param text
     * @return
     */
    public static JButton primaryBorderButton(String text) {
        return createBorderButton(text, Color.BLACK);
    }

    /**
     * 绿字绿边框透明背景
     *
     * @param text
     * @return
     */
    public static JButton greenBorderButton(String text) {
        return createBorderButton(text, GREEN_BG);
    }

    /**
     * 红字红边框透明背景
     *
     * @param text
     * @return
     */
    public static JButton dangerBorderButton(String text) {
        return createBorderButton(text, DANGER_BG);
    }


    private static JButton DEFAULT_BUTTON = new JButton();
    /**
     * #1890FF  蓝色
     */
    private static final Color PRIMARY_BG = new Color(24, 144, 255);
    /**
     * #FF4D4F  红色
     */
    private static final Color DANGER_BG = new Color(255, 77, 79);
    /*
     *#009688 墨绿色
     */
    private static final Color GREEN_BG = new Color(0, 150, 136);
    /**
     * #F0FFFE 白色
     */
    private static final Color FONT_COLOR = new Color(240, 255, 254);

    /**
     * 创建边框button
     *
     * @param text        文字
     * @param borderColor 边框颜色
     * @return
     */
    private static JButton createBorderButton(String text, Color borderColor) {
        JButton button = new JButton(text);
        button.setBorder(new RoundBorder(Color.gray, 0));
        button.setForeground(borderColor);
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        return button;
    }

    /**
     * 创建背景button
     *
     * @param text 文字
     * @param bg   背景
     * @param fg   字体颜色
     * @return
     */
    private static JButton createBgButton(String text, Color bg, Color fg) {
        JButton button = new RoundButton(text, 5, bg);
        button.setForeground(fg);
        return button;
    }


    /**
     * 椭圆按钮
     */
    private static class RoundButton extends JButton {
        private int radius;
        private Color color;

        public RoundButton(String text, int radius, Color color) {
            super(text);
            this.radius = radius;
            this.color = color;
            super.setBackground(color);
            // 取消画矩形
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, super.getSize().width - 1, super.getSize().height - 1, radius, radius);
            super.paintComponent(g2);
            g2.dispose();
        }

        /**
         * 创建与默认按钮大小相同的 内边距
         *
         * @param color
         * @param radius
         * @return
         */
        public Border createRoundBorder(Color color, int radius) {
            return new RoundBorder(color, radius);
        }
    }

    /**
     * 椭圆边框
     */
    public static class RoundBorder implements Border {

        private Color color;

        private int radius;

        public RoundBorder(Color color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return DEFAULT_BUTTON.getBorder().getBorderInsets(c);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }


        // 实现Border（父类）方法
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width,
                                int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, radius, radius);
            g2.dispose();
        }

    }

}

