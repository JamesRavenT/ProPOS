package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetF implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){

        List<String> t1 = new ArrayList<>(List.of("Salmon", "Katsudon", "Katsudon", "Beef Yakiudon", "Seaweed Salad", "Katsudon"));
        List<String> t2 = new ArrayList<>(List.of("Cucumber Lemonade", "Chocolate Cake"));
        List<String> t3 = new ArrayList<>(List.of("Katsudon", "Beef Yakiudon", "Salmon"));
        List<String> t4 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t5 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t6 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon"));
        List<String> t7 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Katsudon", "Cucumber Lemonade", "Seaweed Salad"));
        List<String> t8 = new ArrayList<>(List.of("Cucumber Lemonade", "Seaweed Salad", "Chocolate Cake", "Aburi Salmon", "Salmon"));
        List<String> t9 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Beef Yakiudon", "Katsudon"));
        List<String> t10 = new ArrayList<>(List.of("Aburi Salmon", "Katsudon", "Salmon"));
        List<String> t11 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t12 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t13 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t14 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t15 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Seaweed Salad", "Chocolate Cake", "Salmon"));
        List<String> t16 = new ArrayList<>(List.of("Chocolate Cake", "Salmon"));
        List<String> t17 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Aburi Salmon"));
        List<String> t18 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon"));
        List<String> t19 = new ArrayList<>(List.of("Salmon"));
        List<String> t20 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set", "Chocolate Cake", "Salmon"));
        List<String> t21 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Katsudon", "Salmon"));
        List<String> t22 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Katsudon"));
        List<String> t23 = new ArrayList<>(List.of("Seaweed Salad", "Salmon"));
        List<String> t24 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t25 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Chocolate Cake", "Seaweed Salad", "Katsudon", "Beef Yakiudon"));
        List<String> t26 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade", "Aburi Salmon", "Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t27 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Aburi Salmon", "Salmon"));
        List<String> t28 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t29 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Aburi Salmon"));
        List<String> t30 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad", "Chocolate Cake", "Katsudon", "Beef Yakiudon", "Premium Sushi Set"));
        List<String> t31 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Beef Yakiudon", "Katsudon", "Cucumber Lemonade", "Salmon", "Aburi Salmon"));
        List<String> t32 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t33 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Premium Sushi Set", "Salmon"));
        List<String> t34 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t35 = new ArrayList<>(List.of("Cucumber Lemonade", "Premium Sushi Set", "Premium Sushi Set", "Aburi Salmon", "Beef Yakiudon", "Seaweed Salad", "Salmon"));
        List<String> t36 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t37 = new ArrayList<>(List.of("Cucumber Lemonade", "Aburi Salmon", "Salmon", "Chocolate Cake"));
        List<String> t38 = new ArrayList<>(List.of("Salmon", "Salmon", "Salmon", "Seaweed Salad", "Premium Sushi Set", "Beef Yakiudon"));
        List<String> t39 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Katsudon", "Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t40 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Premium Sushi Set", "Salmon"));
        List<String> t41 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Beef Yakiudon", "Beef Yakiudon", "Salmon", "Premium Sushi Set"));
        List<String> t42 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Katsudon", "Cucumber Lemonade", "Salmon", "Aburi Salmon"));
        List<String> t43 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad"));
        List<String> t44 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Katsudon", "Cucumber Lemonade"));
        List<String> t45 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set"));
        List<String> t46 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Beef Yakiudon", "Premium Sushi Set"));
        List<String> t47 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Premium Sushi Set", "Salmon", "Salmon", "Seaweed Salad"));
        List<String> t48 = new ArrayList<>(List.of("Beef Yakiudon", "Katsudon", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t49 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad"));
        List<String> t50 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t51 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Salmon", "Premium Sushi Set", "Katsudon"));
        List<String> t52 = new ArrayList<>(List.of("Aburi Salmon", "Katsudon", "Seaweed Salad"));
        List<String> t53 = new ArrayList<>(List.of("Salmon"));
        List<String> t54 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t55 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Premium Sushi Set", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t56 = new ArrayList<>(List.of("Cucumber Lemonade", "Seaweed Salad", "Cucumber Lemonade", "Cucumber Lemonade", "Seaweed Salad"));
        List<String> t57 = new ArrayList<>(List.of("Seaweed Salad", "Salmon"));
        List<String> t58 = new ArrayList<>(List.of("Salmon"));
        List<String> t59 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t60 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Beef Yakiudon", "Cucumber Lemonade", "Seaweed Salad"));
        List<String> t61 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Salmon", "Beef Yakiudon"));
        List<String> t62 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Aburi Salmon", "Chocolate Cake"));
        List<String> t63 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t64 = new ArrayList<>(List.of("Salmon"));
        List<String> t65 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t66 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon", "Salmon", "Cucumber Lemonade"));
        List<String> t67 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Salmon", "Cucumber Lemonade", "Salmon"));
        List<String> t68 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Salmon"));
        List<String> t69 = new ArrayList<>(List.of("Cucumber Lemonade", "Seaweed Salad", "Katsudon", "Seaweed Salad", "Salmon", "Seaweed Salad"));
        List<String> t70 = new ArrayList<>(List.of("Aburi Salmon", "Chocolate Cake", "Chocolate Cake", "Aburi Salmon", "Seaweed Salad"));
        List<String> t71 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon", "Beef Yakiudon"));
        List<String> t72 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t73 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Premium Sushi Set", "Chocolate Cake", "Chocolate Cake", "Cucumber Lemonade"));
        List<String> t74 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade", "Salmon", "Seaweed Salad", "Premium Sushi Set", "Premium Sushi Set", "Salmon"));
        List<String> t75 = new ArrayList<>(List.of("Salmon"));
        List<String> t76 = new ArrayList<>(List.of("Cucumber Lemonade", "Katsudon", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t77 = new ArrayList<>(List.of("Katsudon", "Salmon", "Cucumber Lemonade", "Aburi Salmon"));
        List<String> t78 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Salmon", "Salmon", "Seaweed Salad", "Salmon", "Chocolate Cake"));
        List<String> t79 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t80 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade"));
        List<String> t81 = new ArrayList<>(List.of("Beef Yakiudon", "Aburi Salmon"));
        List<String> t82 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t83 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Katsudon", "Premium Sushi Set", "Aburi Salmon", "Beef Yakiudon"));
        List<String> t84 = new ArrayList<>(List.of("Salmon"));
        List<String> t85 = new ArrayList<>(List.of("Katsudon", "Salmon", "Aburi Salmon", "Chocolate Cake", "Premium Sushi Set", "Katsudon"));
        List<String> t86 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Salmon", "Beef Yakiudon", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t87 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad"));
        List<String> t88 = new ArrayList<>(List.of("Katsudon"));
        List<String> t89 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Cucumber Lemonade", "Premium Sushi Set", "Katsudon", "Chocolate Cake", "Aburi Salmon"));
        List<String> t90 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Chocolate Cake", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t91 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Salmon", "Seaweed Salad", "Salmon", "Seaweed Salad", "Chocolate Cake"));
        List<String> t92 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Beef Yakiudon", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t93 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t94 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Aburi Salmon", "Seaweed Salad"));
        List<String> t95 = new ArrayList<>(List.of("Salmon"));
        List<String> t96 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t97 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Aburi Salmon", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t98 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Premium Sushi Set", "Katsudon"));
        List<String> t99 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Salmon", "Aburi Salmon", "Beef Yakiudon", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t100 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t101 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Salmon", "Salmon", "Salmon", "Beef Yakiudon"));
        List<String> t102 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t103 = new ArrayList<>(List.of("Seaweed Salad", "Katsudon", "Beef Yakiudon", "Salmon", "Salmon", "Salmon", "Katsudon"));
        List<String> t104 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t105 = new ArrayList<>(List.of("Salmon", "Salmon", "Cucumber Lemonade", "Salmon", "Seaweed Salad", "Katsudon"));
        List<String> t106 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Salmon", "Salmon", "Chocolate Cake", "Salmon"));
        List<String> t107 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Salmon", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t108 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t109 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t110 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set", "Seaweed Salad", "Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t111 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Beef Yakiudon", "Salmon", "Chocolate Cake"));
        List<String> t112 = new ArrayList<>(List.of("Salmon", "Salmon", "Aburi Salmon", "Salmon", "Premium Sushi Set"));
        List<String> t113 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad", "Premium Sushi Set"));
        List<String> t114 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon", "Salmon", "Salmon", "Seaweed Salad"));
        List<String> t115 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad", "Katsudon", "Salmon", "Katsudon", "Salmon"));
        List<String> t116 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Cucumber Lemonade"));
        List<String> t117 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Aburi Salmon", "Premium Sushi Set", "Seaweed Salad", "Beef Yakiudon", "Premium Sushi Set"));
        List<String> t118 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Aburi Salmon"));
        List<String> t119 = new ArrayList<>(List.of("Salmon", "Seaweed Salad"));
        List<String> t120 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Chocolate Cake", "Seaweed Salad"));
        List<String> t121 = new ArrayList<>(List.of("Salmon"));
        List<String> t122 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t123 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t124 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set", "Katsudon", "Beef Yakiudon", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t125 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t126 = new ArrayList<>(List.of("Chocolate Cake", "Salmon"));
        List<String> t127 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t128 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Seaweed Salad", "Katsudon", "Aburi Salmon", "Salmon"));
        List<String> t129 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t130 = new ArrayList<>(List.of("Seaweed Salad", "Aburi Salmon"));
        List<String> t131 = new ArrayList<>(List.of("Salmon", "Salmon", "Katsudon", "Seaweed Salad", "Cucumber Lemonade", "Cucumber Lemonade", "Aburi Salmon"));
        List<String> t132 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t133 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t134 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t135 = new ArrayList<>(List.of("Cucumber Lemonade", "Aburi Salmon", "Salmon"));
        List<String> t136 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t137 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t138 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set", "Seaweed Salad", "Katsudon"));
        List<String> t139 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t140 = new ArrayList<>(List.of("Cucumber Lemonade", "Katsudon", "Cucumber Lemonade"));
        List<String> t141 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Katsudon", "Katsudon", "Salmon", "Chocolate Cake", "Salmon"));
        List<String> t142 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Chocolate Cake"));
        List<String> t143 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Seaweed Salad", "Beef Yakiudon", "Seaweed Salad", "Chocolate Cake"));
        List<String> t144 = new ArrayList<>(List.of("Aburi Salmon", "Chocolate Cake", "Premium Sushi Set", "Katsudon", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t145 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad", "Beef Yakiudon", "Katsudon", "Salmon"));
        List<String> t146 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon"));
        List<String> t147 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Salmon", "Katsudon", "Seaweed Salad", "Katsudon", "Premium Sushi Set"));
        List<String> t148 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t149 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad", "Beef Yakiudon", "Seaweed Salad", "Katsudon", "Seaweed Salad"));
        List<String> t150 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Beef Yakiudon", "Salmon", "Salmon", "Chocolate Cake"));
        List<String> t151 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon", "Premium Sushi Set", "Cucumber Lemonade", "Aburi Salmon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t152 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Beef Yakiudon"));
        List<String> t153 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad", "Katsudon", "Seaweed Salad", "Seaweed Salad"));
        List<String> t154 = new ArrayList<>(List.of("Katsudon", "Salmon", "Salmon", "Beef Yakiudon"));
        List<String> t155 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t156 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set"));
        List<String> t157 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Salmon"));
        List<String> t158 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t159 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t160 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t161 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t162 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Katsudon", "Salmon"));
        List<String> t163 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon"));
        List<String> t164 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Seaweed Salad"));
        List<String> t165 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t166 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t167 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t168 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Chocolate Cake", "Salmon", "Seaweed Salad", "Beef Yakiudon", "Premium Sushi Set"));
        List<String> t169 = new ArrayList<>(List.of("Salmon", "Katsudon", "Beef Yakiudon", "Seaweed Salad", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t170 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Cucumber Lemonade"));
        List<String> t171 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Aburi Salmon", "Aburi Salmon", "Aburi Salmon", "Aburi Salmon", "Salmon"));
        List<String> t172 = new ArrayList<>(List.of("Seaweed Salad", "Katsudon", "Beef Yakiudon", "Chocolate Cake", "Salmon", "Seaweed Salad", "Salmon"));
        List<String> t173 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Katsudon", "Beef Yakiudon"));
        List<String> t174 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Chocolate Cake", "Salmon"));
        List<String> t175 = new ArrayList<>(List.of("Cucumber Lemonade", "Beef Yakiudon", "Premium Sushi Set", "Premium Sushi Set", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t176 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Seaweed Salad", "Aburi Salmon", "Aburi Salmon", "Seaweed Salad", "Cucumber Lemonade"));
        List<String> t177 = new ArrayList<>(List.of("Beef Yakiudon", "Cucumber Lemonade", "Chocolate Cake", "Aburi Salmon"));
        List<String> t178 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade", "Seaweed Salad", "Premium Sushi Set", "Aburi Salmon", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t179 = new ArrayList<>(List.of("Cucumber Lemonade", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Katsudon"));
        List<String> t180 = new ArrayList<>(List.of("Seaweed Salad", "Salmon"));
        List<String> t181 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade", "Salmon", "Premium Sushi Set", "Chocolate Cake", "Katsudon"));
        List<String> t182 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t183 = new ArrayList<>(List.of("Katsudon", "Beef Yakiudon", "Aburi Salmon"));
        List<String> t184 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t185 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Beef Yakiudon", "Salmon", "Premium Sushi Set", "Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t186 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t187 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t188 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad"));
        List<String> t189 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t190 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Beef Yakiudon", "Cucumber Lemonade", "Premium Sushi Set", "Beef Yakiudon"));
        List<String> t191 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Salmon", "Cucumber Lemonade"));
        List<String> t192 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set", "Seaweed Salad", "Aburi Salmon", "Seaweed Salad"));
        List<String> t193 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Cucumber Lemonade", "Salmon", "Salmon", "Seaweed Salad", "Chocolate Cake"));
        List<String> t194 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t195 = new ArrayList<>(List.of("Premium Sushi Set", "Katsudon", "Salmon", "Cucumber Lemonade"));
        List<String> t196 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Cucumber Lemonade", "Salmon", "Cucumber Lemonade", "Chocolate Cake"));
        List<String> t197 = new ArrayList<>(List.of("Katsudon", "Salmon"));
        List<String> t198 = new ArrayList<>(List.of("Beef Yakiudon", "Aburi Salmon"));
        List<String> t199 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Beef Yakiudon", "Cucumber Lemonade", "Aburi Salmon", "Katsudon"));
        List<String> t200 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Katsudon", "Katsudon", "Beef Yakiudon", "Chocolate Cake", "Katsudon"));
        List<String> t201 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad"));
        List<String> t202 = new ArrayList<>(List.of("Aburi Salmon", "Chocolate Cake", "Salmon", "Cucumber Lemonade", "Beef Yakiudon", "Salmon"));
        List<String> t203 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "Salmon", "Cucumber Lemonade"));
        List<String> t204 = new ArrayList<>(List.of("Katsudon", "Salmon"));
        List<String> t205 = new ArrayList<>(List.of("Beef Yakiudon", "Katsudon", "Chocolate Cake", "Aburi Salmon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t206 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Premium Sushi Set"));
        List<String> t207 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Seaweed Salad", "Chocolate Cake", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t208 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t209 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon", "Premium Sushi Set"));
        List<String> t210 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t211 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad", "Premium Sushi Set"));
        List<String> t212 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t213 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Beef Yakiudon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t214 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Katsudon", "Salmon", "Salmon"));
        List<String> t215 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Salmon", "Salmon"));
        List<String> t216 = new ArrayList<>(List.of("Salmon"));
        List<String> t217 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t218 = new ArrayList<>(List.of("Katsudon", "Beef Yakiudon", "Katsudon", "Seaweed Salad"));
        List<String> t219 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t220 = new ArrayList<>(List.of("Salmon", "Salmon", "Katsudon", "Katsudon", "Salmon", "Cucumber Lemonade"));
        List<String> t221 = new ArrayList<>(List.of("Katsudon"));
        List<String> t222 = new ArrayList<>(List.of("Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t223 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t224 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Beef Yakiudon", "Premium Sushi Set"));
        List<String> t225 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Salmon", "Katsudon"));
        List<String> t226 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Salmon"));
        List<String> t227 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t228 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t229 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set", "Aburi Salmon", "Katsudon"));
        List<String> t230 = new ArrayList<>(List.of("Seaweed Salad", "Katsudon", "Beef Yakiudon", "Salmon", "Aburi Salmon", "Aburi Salmon"));
        List<String> t231 = new ArrayList<>(List.of("Salmon"));
        List<String> t232 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Seaweed Salad"));
        List<String> t233 = new ArrayList<>(List.of("Cucumber Lemonade", "Aburi Salmon", "Chocolate Cake"));
        List<String> t234 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t235 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t236 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t237 = new ArrayList<>(List.of("Salmon"));
        List<String> t238 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t239 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Katsudon", "Aburi Salmon", "Katsudon", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t240 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Salmon", "Katsudon", "Seaweed Salad", "Salmon"));
        List<String> t241 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad", "Chocolate Cake", "Aburi Salmon", "Chocolate Cake", "Aburi Salmon", "Cucumber Lemonade"));
        List<String> t242 = new ArrayList<>(List.of("Katsudon", "Salmon", "Premium Sushi Set", "Seaweed Salad"));
        List<String> t243 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t244 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t245 = new ArrayList<>(List.of("Salmon", "Salmon", "Aburi Salmon", "Katsudon", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t246 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon"));
        List<String> t247 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad"));
        List<String> t248 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Aburi Salmon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t249 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Katsudon"));
        List<String> t250 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t251 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set"));
        List<String> t252 = new ArrayList<>(List.of("Aburi Salmon", "Chocolate Cake", "Seaweed Salad", "Cucumber Lemonade", "Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t253 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Aburi Salmon"));
        List<String> t254 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad"));
        List<String> t255 = new ArrayList<>(List.of("Salmon"));
        List<String> t256 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set", "Cucumber Lemonade", "Seaweed Salad", "Chocolate Cake", "Seaweed Salad", "Premium Sushi Set"));
        List<String> t257 = new ArrayList<>(List.of("Salmon", "Salmon"));
        List<String> t258 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad"));
        List<String> t259 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon", "Cucumber Lemonade", "Salmon", "Cucumber Lemonade", "Seaweed Salad"));
        List<String> t260 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Seaweed Salad", "Salmon"));
        List<String> t261 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Salmon", "Cucumber Lemonade", "Beef Yakiudon", "Aburi Salmon"));
        List<String> t262 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t263 = new ArrayList<>(List.of("Cucumber Lemonade", "Chocolate Cake", "Chocolate Cake", "Cucumber Lemonade"));
        List<String> t264 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t265 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set"));
        List<String> t266 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t267 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t268 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Salmon", "Chocolate Cake", "Salmon", "Chocolate Cake"));
        List<String> t269 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Salmon", "Salmon"));
        List<String> t270 = new ArrayList<>(List.of("Cucumber Lemonade", "Seaweed Salad", "Seaweed Salad"));
        List<String> t271 = new ArrayList<>(List.of("Beef Yakiudon", "Aburi Salmon"));
        List<String> t272 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t273 = new ArrayList<>(List.of("Seaweed Salad", "Katsudon", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t274 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Aburi Salmon"));
        List<String> t275 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon"));
        List<String> t276 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Chocolate Cake", "Chocolate Cake", "Aburi Salmon", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t277 = new ArrayList<>(List.of("Katsudon", "Aburi Salmon", "Premium Sushi Set"));
        List<String> t278 = new ArrayList<>(List.of("Cucumber Lemonade", "Katsudon", "Chocolate Cake"));
        List<String> t279 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t280 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Salmon"));
        List<String> t281 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Cucumber Lemonade"));
        List<String> t282 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Aburi Salmon", "Beef Yakiudon"));
        List<String> t283 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t284 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t285 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Salmon", "Beef Yakiudon", "Katsudon", "Katsudon", "Cucumber Lemonade"));
        List<String> t286 = new ArrayList<>(List.of("Seaweed Salad", "Cucumber Lemonade", "Salmon"));
        List<String> t287 = new ArrayList<>(List.of("Salmon", "Salmon", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t288 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Cucumber Lemonade", "Salmon"));
        List<String> t289 = new ArrayList<>(List.of("Premium Sushi Set", "Katsudon", "Chocolate Cake"));
        List<String> t290 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Salmon"));
        List<String> t291 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon"));
        List<String> t292 = new ArrayList<>(List.of("Salmon", "Katsudon", "Premium Sushi Set", "Premium Sushi Set", "Seaweed Salad"));
        List<String> t293 = new ArrayList<>(List.of("Premium Sushi Set", "Katsudon", "Beef Yakiudon", "Salmon"));
        List<String> t294 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Chocolate Cake", "Katsudon", "Chocolate Cake"));
        List<String> t295 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t296 = new ArrayList<>(List.of("Katsudon"));
        List<String> t297 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon"));
        List<String> t298 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake"));
        List<String> t299 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Chocolate Cake", "Aburi Salmon"));
        List<String> t300 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Seaweed Salad"));
        List<String> t301 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set", "Salmon"));
        List<String> t302 = new ArrayList<>(List.of("Salmon", "Salmon", "Cucumber Lemonade", "Salmon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t303 = new ArrayList<>(List.of("Cucumber Lemonade", "Katsudon", "Premium Sushi Set"));
        List<String> t304 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t305 = new ArrayList<>(List.of("Aburi Salmon", "Katsudon"));
        List<String> t306 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t307 = new ArrayList<>(List.of("Cucumber Lemonade", "Aburi Salmon"));
        List<String> t308 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Katsudon", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t309 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t310 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade", "Salmon", "Beef Yakiudon"));
        List<String> t311 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t312 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Salmon", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t313 = new ArrayList<>(List.of("Cucumber Lemonade", "Seaweed Salad", "Chocolate Cake", "Katsudon", "Salmon", "Katsudon"));
        List<String> t314 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set", "Salmon", "Premium Sushi Set", "Seaweed Salad", "Katsudon"));
        List<String> t315 = new ArrayList<>(List.of("Seaweed Salad", "Cucumber Lemonade", "Salmon", "Katsudon"));
        List<String> t316 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t317 = new ArrayList<>(List.of("Salmon", "Salmon", "Seaweed Salad", "Salmon", "Aburi Salmon", "Chocolate Cake", "Salmon"));
        List<String> t318 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t319 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade", "Beef Yakiudon"));
        List<String> t320 = new ArrayList<>(List.of("Aburi Salmon", "Katsudon", "Seaweed Salad", "Premium Sushi Set", "Seaweed Salad", "Katsudon", "Chocolate Cake"));
        List<String> t321 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Katsudon", "Salmon", "Cucumber Lemonade", "Katsudon", "Seaweed Salad"));
        List<String> t322 = new ArrayList<>(List.of("Salmon", "Salmon", "Aburi Salmon"));
        List<String> t323 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t324 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad"));
        List<String> t325 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t326 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t327 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Cucumber Lemonade", "Katsudon", "Chocolate Cake"));
        List<String> t328 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Premium Sushi Set", "Salmon", "Katsudon", "Salmon"));
        List<String> t329 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t330 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t331 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Cucumber Lemonade"));
        List<String> t332 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t333 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set", "Salmon", "Chocolate Cake", "Seaweed Salad", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t334 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t335 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t336 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Salmon", "Salmon", "Seaweed Salad", "Salmon"));
        List<String> t337 = new ArrayList<>(List.of("Seaweed Salad", "Premium Sushi Set", "Premium Sushi Set", "Seaweed Salad", "Premium Sushi Set", "Beef Yakiudon", "Salmon"));
        List<String> t338 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t339 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t340 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Salmon", "Salmon", "Katsudon"));
        List<String> t341 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon", "Chocolate Cake", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t342 = new ArrayList<>(List.of("Seaweed Salad", "Aburi Salmon", "Salmon"));
        List<String> t343 = new ArrayList<>(List.of("Chocolate Cake", "Salmon"));
        List<String> t344 = new ArrayList<>(List.of("Salmon", "Katsudon", "Chocolate Cake", "Chocolate Cake", "Cucumber Lemonade", "Salmon", "Salmon"));
        List<String> t345 = new ArrayList<>(List.of("Katsudon", "Salmon"));
        List<String> t346 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Salmon", "Salmon", "Salmon"));
        List<String> t347 = new ArrayList<>(List.of("Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t348 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t349 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Seaweed Salad", "Chocolate Cake"));
        List<String> t350 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Beef Yakiudon", "Salmon", "Chocolate Cake", "Salmon"));
        List<String> t351 = new ArrayList<>(List.of("Beef Yakiudon", "Katsudon", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t352 = new ArrayList<>(List.of("Aburi Salmon", "Salmon"));
        List<String> t353 = new ArrayList<>(List.of("Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t354 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon"));
        List<String> t355 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad"));
        List<String> t356 = new ArrayList<>(List.of("Salmon", "Salmon", "Beef Yakiudon"));
        List<String> t357 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad", "Salmon", "Beef Yakiudon", "Salmon"));
        List<String> t358 = new ArrayList<>(List.of("Salmon", "Salmon", "Cucumber Lemonade", "Salmon", "Seaweed Salad", "Premium Sushi Set"));
        List<String> t359 = new ArrayList<>(List.of("Salmon", "Salmon", "Cucumber Lemonade", "Salmon", "Salmon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t360 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Cucumber Lemonade"));
        List<String> t361 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Aburi Salmon", "Katsudon"));
        List<String> t362 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t363 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Aburi Salmon", "Seaweed Salad", "Salmon", "Premium Sushi Set"));
        List<String> t364 = new ArrayList<>(List.of("Chocolate Cake", "Cucumber Lemonade", "Salmon", "Chocolate Cake"));
        List<String> t365 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t366 = new ArrayList<>(List.of("Beef Yakiudon", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t367 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon", "Beef Yakiudon", "Salmon", "Katsudon", "Katsudon", "Premium Sushi Set"));
        List<String> t368 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Aburi Salmon", "Seaweed Salad", "Seaweed Salad", "Salmon", "Cucumber Lemonade"));
        List<String> t369 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Katsudon", "Katsudon", "Beef Yakiudon"));
        List<String> t370 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Chocolate Cake", "Cucumber Lemonade", "Salmon", "Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t371 = new ArrayList<>(List.of("Beef Yakiudon", "Katsudon"));
        List<String> t372 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Salmon", "Salmon"));
        List<String> t373 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade", "Salmon", "Beef Yakiudon"));
        List<String> t374 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "Katsudon", "Seaweed Salad", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t375 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Seaweed Salad", "Premium Sushi Set", "Cucumber Lemonade", "Cucumber Lemonade", "Katsudon"));
        List<String> t376 = new ArrayList<>(List.of("Salmon", "Katsudon", "Beef Yakiudon", "Seaweed Salad", "Chocolate Cake"));
        List<String> t377 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Salmon", "Salmon", "Katsudon", "Cucumber Lemonade", "Cucumber Lemonade"));
        List<String> t378 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "Aburi Salmon", "Seaweed Salad"));
        List<String> t379 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t380 = new ArrayList<>(List.of("Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade", "Salmon", "Seaweed Salad", "Aburi Salmon", "Aburi Salmon"));
        List<String> t381 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon"));
        List<String> t382 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Salmon", "Salmon"));
        List<String> t383 = new ArrayList<>(List.of("Katsudon", "Premium Sushi Set", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t384 = new ArrayList<>(List.of("Katsudon"));
        List<String> t385 = new ArrayList<>(List.of("Cucumber Lemonade", "Katsudon", "Seaweed Salad", "Beef Yakiudon", "Salmon", "Salmon", "Premium Sushi Set"));
        List<String> t386 = new ArrayList<>(List.of("Katsudon", "Beef Yakiudon", "Katsudon"));
        List<String> t387 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade"));
        List<String> t388 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t389 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Cucumber Lemonade", "Aburi Salmon", "Aburi Salmon", "Salmon", "Seaweed Salad"));
        List<String> t390 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "Salmon"));
        List<String> t391 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Salmon", "Chocolate Cake", "Katsudon", "Seaweed Salad"));
        List<String> t392 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Salmon", "Salmon"));
        List<String> t393 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t394 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Aburi Salmon", "Premium Sushi Set", "Seaweed Salad", "Premium Sushi Set", "Seaweed Salad"));
        List<String> t395 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad", "Aburi Salmon", "Chocolate Cake", "Premium Sushi Set", "Salmon", "Chocolate Cake"));
        List<String> t396 = new ArrayList<>(List.of("Katsudon", "Aburi Salmon"));
        List<String> t397 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t398 = new ArrayList<>(List.of("Seaweed Salad", "Cucumber Lemonade", "Premium Sushi Set", "Premium Sushi Set", "Salmon", "Seaweed Salad"));
        List<String> t399 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad"));
        List<String> t400 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t401 = new ArrayList<>(List.of("Cucumber Lemonade", "Premium Sushi Set", "Beef Yakiudon", "Salmon"));
        List<String> t402 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Premium Sushi Set", "Katsudon", "Salmon", "Chocolate Cake"));
        List<String> t403 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t404 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon"));
        List<String> t405 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Salmon", "Aburi Salmon", "Seaweed Salad"));
        List<String> t406 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set"));
        List<String> t407 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t408 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t409 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t410 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t411 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t412 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Salmon"));
        List<String> t413 = new ArrayList<>(List.of("Salmon", "Katsudon", "Cucumber Lemonade"));
        List<String> t414 = new ArrayList<>(List.of("Katsudon", "Salmon", "Chocolate Cake"));
        List<String> t415 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Cucumber Lemonade", "Katsudon"));
        List<String> t416 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t417 = new ArrayList<>(List.of("Salmon", "Katsudon", "Seaweed Salad", "Katsudon"));
        List<String> t418 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Seaweed Salad"));
        List<String> t419 = new ArrayList<>(List.of("Seaweed Salad", "Cucumber Lemonade", "Beef Yakiudon", "Aburi Salmon"));
        List<String> t420 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake"));
        List<String> t421 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set"));
        List<String> t422 = new ArrayList<>(List.of("Salmon", "Aburi Salmon"));
        List<String> t423 = new ArrayList<>(List.of("Katsudon"));
        List<String> t424 = new ArrayList<>(List.of("Beef Yakiudon", "Premium Sushi Set", "Salmon", "Aburi Salmon", "Premium Sushi Set"));
        List<String> t425 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t426 = new ArrayList<>(List.of("Cucumber Lemonade", "Cucumber Lemonade", "Premium Sushi Set", "Katsudon"));
        List<String> t427 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Katsudon", "Beef Yakiudon"));
        List<String> t428 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Katsudon", "Aburi Salmon", "Premium Sushi Set", "Salmon", "Salmon"));
        List<String> t429 = new ArrayList<>(List.of("Chocolate Cake", "Salmon", "Salmon", "Premium Sushi Set", "Cucumber Lemonade", "Seaweed Salad"));
        List<String> t430 = new ArrayList<>(List.of("Beef Yakiudon", "Cucumber Lemonade", "Aburi Salmon", "Aburi Salmon"));
        List<String> t431 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon"));
        List<String> t432 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t433 = new ArrayList<>(List.of("Salmon", "Katsudon"));
        List<String> t434 = new ArrayList<>(List.of("Beef Yakiudon", "Aburi Salmon"));
        List<String> t435 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t436 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon"));
        List<String> t437 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon", "Aburi Salmon", "Seaweed Salad", "Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t438 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Aburi Salmon", "Premium Sushi Set", "Katsudon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t439 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Seaweed Salad"));
        List<String> t440 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set"));
        List<String> t441 = new ArrayList<>(List.of("Cucumber Lemonade", "Chocolate Cake", "Premium Sushi Set", "Aburi Salmon", "Salmon", "Premium Sushi Set"));
        List<String> t442 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t443 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Chocolate Cake", "Premium Sushi Set", "Premium Sushi Set", "Salmon", "Beef Yakiudon"));
        List<String> t444 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t445 = new ArrayList<>(List.of("Katsudon", "Cucumber Lemonade", "Salmon", "Aburi Salmon"));
        List<String> t446 = new ArrayList<>(List.of("Salmon", "Salmon", "Aburi Salmon", "Chocolate Cake", "Chocolate Cake", "Salmon", "Aburi Salmon"));
        List<String> t447 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Aburi Salmon", "Beef Yakiudon", "Aburi Salmon", "Seaweed Salad", "Seaweed Salad"));
        List<String> t448 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Salmon", "Chocolate Cake", "Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t449 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set", "Aburi Salmon", "Premium Sushi Set", "Katsudon", "Seaweed Salad"));
        List<String> t450 = new ArrayList<>(List.of("Katsudon"));
        List<String> t451 = new ArrayList<>(List.of("Cucumber Lemonade", "Premium Sushi Set"));
        List<String> t452 = new ArrayList<>(List.of("Katsudon", "Salmon", "Salmon"));
        List<String> t453 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad", "Seaweed Salad", "Premium Sushi Set", "Premium Sushi Set", "Salmon", "Premium Sushi Set"));
        List<String> t454 = new ArrayList<>(List.of("Aburi Salmon", "Salmon", "Aburi Salmon", "Katsudon", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t455 = new ArrayList<>(List.of("Premium Sushi Set", "Seaweed Salad", "Chocolate Cake", "Aburi Salmon", "Aburi Salmon"));
        List<String> t456 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t457 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Cucumber Lemonade", "Cucumber Lemonade", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t458 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Cucumber Lemonade", "Aburi Salmon", "Cucumber Lemonade", "Chocolate Cake"));
        List<String> t459 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Aburi Salmon", "Premium Sushi Set", "Seaweed Salad"));
        List<String> t460 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t461 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad", "Salmon", "Chocolate Cake", "Cucumber Lemonade", "Aburi Salmon", "Chocolate Cake"));
        List<String> t462 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Cucumber Lemonade", "Cucumber Lemonade", "Katsudon", "Aburi Salmon"));
        List<String> t463 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Chocolate Cake", "Katsudon", "Salmon", "Seaweed Salad"));
        List<String> t464 = new ArrayList<>(List.of("Premium Sushi Set", "Cucumber Lemonade", "Cucumber Lemonade", "Aburi Salmon", "Salmon", "Chocolate Cake", "Katsudon"));
        List<String> t465 = new ArrayList<>(List.of("Cucumber Lemonade", "Beef Yakiudon", "Premium Sushi Set", "Seaweed Salad", "Salmon"));
        List<String> t466 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad", "Cucumber Lemonade"));
        List<String> t467 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon", "Salmon"));
        List<String> t468 = new ArrayList<>(List.of("Salmon", "Katsudon", "Katsudon", "Beef Yakiudon"));
        List<String> t469 = new ArrayList<>(List.of("Salmon", "Seaweed Salad", "Chocolate Cake", "Katsudon", "Chocolate Cake", "Seaweed Salad", "Chocolate Cake"));
        List<String> t470 = new ArrayList<>(List.of("Katsudon"));
        List<String> t471 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t472 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Aburi Salmon", "Katsudon", "Aburi Salmon"));
        List<String> t473 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon"));
        List<String> t474 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Salmon"));
        List<String> t475 = new ArrayList<>(List.of("Salmon", "Premium Sushi Set", "Chocolate Cake", "Chocolate Cake"));
        List<String> t476 = new ArrayList<>(List.of("Katsudon", "Salmon", "Seaweed Salad"));
        List<String> t477 = new ArrayList<>(List.of("Salmon", "Cucumber Lemonade", "Beef Yakiudon", "Salmon", "Chocolate Cake", "Salmon", "Beef Yakiudon"));
        List<String> t478 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Katsudon", "Salmon", "Seaweed Salad"));
        List<String> t479 = new ArrayList<>(List.of("Seaweed Salad", "Salmon", "Seaweed Salad"));
        List<String> t480 = new ArrayList<>(List.of("Cucumber Lemonade", "Salmon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t481 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon", "Premium Sushi Set", "Aburi Salmon", "Salmon", "Katsudon", "Seaweed Salad"));
        List<String> t482 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t483 = new ArrayList<>(List.of("Katsudon", "Seaweed Salad", "Cucumber Lemonade", "Chocolate Cake", "Premium Sushi Set", "Cucumber Lemonade"));
        List<String> t484 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t485 = new ArrayList<>(List.of("Cucumber Lemonade"));
        List<String> t486 = new ArrayList<>(List.of("Salmon"));
        List<String> t487 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t488 = new ArrayList<>(List.of("Aburi Salmon", "Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon", "Cucumber Lemonade"));
        List<String> t489 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t490 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Salmon"));
        List<String> t491 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t492 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Chocolate Cake"));
        List<String> t493 = new ArrayList<>(List.of("Cucumber Lemonade", "Beef Yakiudon", "Seaweed Salad", "Aburi Salmon"));
        List<String> t494 = new ArrayList<>(List.of("Premium Sushi Set", "Beef Yakiudon"));
        List<String> t495 = new ArrayList<>(List.of("Salmon", "Chocolate Cake", "Katsudon", "Salmon"));
        List<String> t496 = new ArrayList<>(List.of("Salmon", "Katsudon", "Seaweed Salad"));
        List<String> t497 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Katsudon", "Aburi Salmon", "Aburi Salmon", "Chocolate Cake", "Seaweed Salad"));
        List<String> t498 = new ArrayList<>(List.of("Salmon", "Aburi Salmon", "Cucumber Lemonade", "Salmon"));
        List<String> t499 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Chocolate Cake"));
        List<String> t500 = new ArrayList<>(List.of("Salmon", "Beef Yakiudon", "Aburi Salmon", "Salmon", "Beef Yakiudon"));

        Collections.addAll(transactionsTB,
                t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
                t11, t12, t13, t14, t15, t16, t17, t18, t19, t20,
                t21, t22, t23, t24, t25, t26, t27, t28, t29, t30,
                t31, t32, t33, t34, t35, t36, t37, t38, t39, t40,
                t41, t42, t43, t44, t45, t46, t47, t48, t49, t50,
                t51, t52, t53, t54, t55, t56, t57, t58, t59, t60,
                t61, t62, t63, t64, t65, t66, t67, t68, t69, t70,
                t71, t72, t73, t74, t75, t76, t77, t78, t79, t80,
                t81, t82, t83, t84, t85, t86, t87, t88, t89, t90,
                t91, t92, t93, t94, t95, t96, t97, t98, t99, t100,
                t101, t102, t103, t104, t105, t106, t107, t108, t109, t110,
                t111, t112, t113, t114, t115, t116, t117, t118, t119, t120,
                t121, t122, t123, t124, t125, t126, t127, t128, t129, t130,
                t131, t132, t133, t134, t135, t136, t137, t138, t139, t140,
                t141, t142, t143, t144, t145, t146, t147, t148, t149, t150,
                t151, t152, t153, t154, t155, t156, t157, t158, t159, t160,
                t161, t162, t163, t164, t165, t166, t167, t168, t169, t170,
                t171, t172, t173, t174, t175, t176, t177, t178, t179, t180,
                t181, t182, t183, t184, t185, t186, t187, t188, t189, t190,
                t191, t192, t193, t194, t195, t196, t197, t198, t199, t200,
                t201, t202, t203, t204, t205, t206, t207, t208, t209, t210,
                t211, t212, t213, t214, t215, t216, t217, t218, t219, t220,
                t221, t222, t223, t224, t225, t226, t227, t228, t229, t230,
                t231, t232, t233, t234, t235, t236, t237, t238, t239, t240,
                t241, t242, t243, t244, t245, t246, t247, t248, t249, t250,
                t251, t252, t253, t254, t255, t256, t257, t258, t259, t260,
                t261, t262, t263, t264, t265, t266, t267, t268, t269, t270,
                t271, t272, t273, t274, t275, t276, t277, t278, t279, t280,
                t281, t282, t283, t284, t285, t286, t287, t288, t289, t290,
                t291, t292, t293, t294, t295, t296, t297, t298, t299, t300,
                t301, t302, t303, t304, t305, t306, t307, t308, t309, t310,
                t311, t312, t313, t314, t315, t316, t317, t318, t319, t320,
                t321, t322, t323, t324, t325, t326, t327, t328, t329, t330,
                t331, t332, t333, t334, t335, t336, t337, t338, t339, t340,
                t341, t342, t343, t344, t345, t346, t347, t348, t349, t350,
                t351, t352, t353, t354, t355, t356, t357, t358, t359, t360,
                t361, t362, t363, t364, t365, t366, t367, t368, t369, t370,
                t371, t372, t373, t374, t375, t376, t377, t378, t379, t380,
                t381, t382, t383, t384, t385, t386, t387, t388, t389, t390,
                t391, t392, t393, t394, t395, t396, t397, t398, t399, t400,
                t401, t402, t403, t404, t405, t406, t407, t408, t409, t410,
                t411, t412, t413, t414, t415, t416, t417, t418, t419, t420,
                t421, t422, t423, t424, t425, t426, t427, t428, t429, t430,
                t431, t432, t433, t434, t435, t436, t437, t438, t439, t440,
                t441, t442, t443, t444, t445, t446, t447, t448, t449, t450,
                t451, t452, t453, t454, t455, t456, t457, t458, t459, t460,
                t461, t462, t463, t464, t465, t466, t467, t468, t469, t470,
                t471, t472, t473, t474, t475, t476, t477, t478, t479, t480,
                t481, t482, t483, t484, t485, t486, t487, t488, t489, t490,
                t491, t492, t493, t494, t495, t496, t497, t498, t499, t500
                );
        for (List<String> transaction : transactionsTB) {
            Set<String> filteredTransactions = new LinkedHashSet<>(transaction);
            transaction.clear();
            transaction.addAll(filteredTransactions);
        }

    }
}
