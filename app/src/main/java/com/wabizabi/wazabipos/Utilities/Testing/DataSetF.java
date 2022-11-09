package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetF implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){

        List<String> t1 = new ArrayList<>(List.of("Salmon sashimi", "Coke", "Premium Sushi Set", "Gyudon", "Premium Sushi Set"));
        List<String> t2 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen"));
        List<String> t3 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Aburi Salmon", "Gyudon", "Coke", "Aburi Salmon", "Salmon sashimi"));
        List<String> t4 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Sea weeds Salad", "Aburi Salmon", "Miso Ramen", "Salmon sashimi"));
        List<String> t5 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Gyudon"));
        List<String> t6 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t7 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set"));
        List<String> t8 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t9 = new ArrayList<>(List.of("Sea weeds Salad", "Coke", "Aburi Salmon", "Coke", "Salmon sashimi", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t10 = new ArrayList<>(List.of("Coke"));
        List<String> t11 = new ArrayList<>(List.of("Coke", "Miso Ramen", "Miso Ramen", "Premium Sushi Set"));
        List<String> t12 = new ArrayList<>(List.of("Aburi Salmon", "Coke", "Salmon sashimi", "Sea weeds Salad", "Sea weeds Salad", "Gyudon", "Salmon sashimi"));
        List<String> t13 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t14 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Chocolate Cake", "Coke", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t15 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t16 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Gyudon"));
        List<String> t17 = new ArrayList<>(List.of("Salmon sashimi", "Coke", "Coke", "Gyudon", "Chocolate Cake", "Coke", "Premium Sushi Set"));
        List<String> t18 = new ArrayList<>(List.of("Gyudon", "Premium Sushi Set", "Sea weeds Salad", "Coke", "Salmon sashimi", "Aburi Salmon"));
        List<String> t19 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Sea weeds Salad", "Aburi Salmon", "Sea weeds Salad"));
        List<String> t20 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set"));
        List<String> t21 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t22 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t23 = new ArrayList<>(List.of("Coke", "Sea weeds Salad", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t24 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon"));
        List<String> t25 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t26 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Coke", "Aburi Salmon"));
        List<String> t27 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t28 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Gyudon", "Miso Ramen"));
        List<String> t29 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Sea weeds Salad", "Coke", "Premium Sushi Set", "Aburi Salmon", "Miso Ramen"));
        List<String> t30 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t31 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon"));
        List<String> t32 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad"));
        List<String> t33 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t34 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set"));
        List<String> t35 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Miso Ramen"));
        List<String> t36 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t37 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon"));
        List<String> t38 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Salmon sashimi"));
        List<String> t39 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Sea weeds Salad", "Coke", "Salmon sashimi"));
        List<String> t40 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Miso Ramen", "Coke", "Gyudon", "Salmon sashimi", "Miso Ramen"));
        List<String> t41 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon", "Miso Ramen", "Sea weeds Salad"));
        List<String> t42 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon", "Sea weeds Salad", "Salmon sashimi"));
        List<String> t43 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t44 = new ArrayList<>(List.of("Coke", "Coke", "Salmon sashimi", "Salmon sashimi"));
        List<String> t45 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t46 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t47 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Aburi Salmon", "Miso Ramen", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t48 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Chocolate Cake", "Salmon sashimi", "Gyudon", "Chocolate Cake", "Coke"));
        List<String> t49 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad", "Salmon sashimi", "Salmon sashimi", "Coke", "Sea weeds Salad", "Coke"));
        List<String> t50 = new ArrayList<>(List.of("Coke", "Salmon sashimi"));
        List<String> t51 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t52 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t53 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Coke", "Gyudon", "Salmon sashimi"));
        List<String> t54 = new ArrayList<>(List.of("Gyudon"));
        List<String> t55 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon"));
        List<String> t56 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen"));
        List<String> t57 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Chocolate Cake", "Coke", "Salmon sashimi"));
        List<String> t58 = new ArrayList<>(List.of("Gyudon"));
        List<String> t59 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Salmon sashimi"));
        List<String> t60 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Gyudon", "Miso Ramen", "Sea weeds Salad"));
        List<String> t61 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Salmon sashimi", "Miso Ramen"));
        List<String> t62 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t63 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t64 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Coke", "Gyudon"));
        List<String> t65 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Premium Sushi Set", "Gyudon", "Gyudon", "Premium Sushi Set"));
        List<String> t66 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t67 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t68 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Gyudon", "Sea weeds Salad", "Miso Ramen", "Sea weeds Salad"));
        List<String> t69 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Salmon sashimi", "Miso Ramen", "Coke", "Salmon sashimi", "Chocolate Cake"));
        List<String> t70 = new ArrayList<>(List.of("Sea weeds Salad", "Coke", "Chocolate Cake", "Coke", "Coke", "Miso Ramen"));
        List<String> t71 = new ArrayList<>(List.of("Miso Ramen", "Coke", "Miso Ramen", "Sea weeds Salad"));
        List<String> t72 = new ArrayList<>(List.of("Miso Ramen", "Coke", "Gyudon", "Aburi Salmon"));
        List<String> t73 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Gyudon"));
        List<String> t74 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen", "Chocolate Cake", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t75 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set"));
        List<String> t76 = new ArrayList<>(List.of("Chocolate Cake", "Aburi Salmon", "Chocolate Cake"));
        List<String> t77 = new ArrayList<>(List.of("Coke", "Sea weeds Salad", "Coke", "Sea weeds Salad", "Salmon sashimi", "Gyudon", "Gyudon"));
        List<String> t78 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t79 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t80 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t81 = new ArrayList<>(List.of("Gyudon", "Miso Ramen"));
        List<String> t82 = new ArrayList<>(List.of("Coke", "Salmon sashimi", "Coke", "Sea weeds Salad", "Aburi Salmon", "Coke"));
        List<String> t83 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t84 = new ArrayList<>(List.of("Coke", "Coke", "Coke", "Miso Ramen", "Sea weeds Salad", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t85 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t86 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t87 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Premium Sushi Set", "Gyudon", "Salmon sashimi"));
        List<String> t88 = new ArrayList<>(List.of("Coke", "Salmon sashimi", "Salmon sashimi", "Miso Ramen"));
        List<String> t89 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Premium Sushi Set", "Coke"));
        List<String> t90 = new ArrayList<>(List.of("Salmon sashimi", "Coke"));
        List<String> t91 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Miso Ramen", "Coke", "Salmon sashimi"));
        List<String> t92 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon", "Aburi Salmon"));
        List<String> t93 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t94 = new ArrayList<>(List.of("Gyudon", "Miso Ramen", "Salmon sashimi", "Coke"));
        List<String> t95 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake", "Coke", "Sea weeds Salad", "Sea weeds Salad", "Salmon sashimi"));
        List<String> t96 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t97 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Coke"));
        List<String> t98 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Miso Ramen", "Premium Sushi Set", "Gyudon", "Salmon sashimi", "Coke"));
        List<String> t99 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t100 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t101 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Sea weeds Salad", "Coke"));
        List<String> t102 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t103 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad", "Coke", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t104 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set"));
        List<String> t105 = new ArrayList<>(List.of("Coke", "Miso Ramen", "Premium Sushi Set", "Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad", "Gyudon"));
        List<String> t106 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad", "Miso Ramen"));
        List<String> t107 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Coke"));
        List<String> t108 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad", "Coke", "Miso Ramen"));
        List<String> t109 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t110 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Sea weeds Salad", "Aburi Salmon", "Gyudon", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t111 = new ArrayList<>(List.of("Gyudon", "Gyudon"));
        List<String> t112 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t113 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Gyudon", "Gyudon", "Aburi Salmon"));
        List<String> t114 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen"));
        List<String> t115 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi"));
        List<String> t116 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set"));
        List<String> t117 = new ArrayList<>(List.of("Aburi Salmon", "Sea weeds Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t118 = new ArrayList<>(List.of("Miso Ramen", "Coke", "Premium Sushi Set", "Chocolate Cake", "Gyudon"));
        List<String> t119 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Gyudon", "Miso Ramen"));
        List<String> t120 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Miso Ramen", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t121 = new ArrayList<>(List.of("Coke", "Coke", "Miso Ramen", "Premium Sushi Set"));
        List<String> t122 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "Coke", "Coke"));
        List<String> t123 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Gyudon", "Gyudon", "Gyudon"));
        List<String> t124 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Aburi Salmon"));
        List<String> t125 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad", "Miso Ramen", "Chocolate Cake", "Chocolate Cake"));
        List<String> t126 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen", "Premium Sushi Set", "Sea weeds Salad", "Coke"));
        List<String> t127 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Miso Ramen", "Premium Sushi Set", "Miso Ramen", "Salmon sashimi"));
        List<String> t128 = new ArrayList<>(List.of("Salmon sashimi", "Coke"));
        List<String> t129 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Gyudon"));
        List<String> t130 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t131 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t132 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen", "Miso Ramen"));
        List<String> t133 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad"));
        List<String> t134 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t135 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi"));
        List<String> t136 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t137 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t138 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon"));
        List<String> t139 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon"));
        List<String> t140 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Aburi Salmon", "Chocolate Cake"));
        List<String> t141 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set"));
        List<String> t142 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon", "Coke", "Coke", "Salmon sashimi", "Aburi Salmon"));
        List<String> t143 = new ArrayList<>(List.of("Coke"));
        List<String> t144 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t145 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Sea weeds Salad"));
        List<String> t146 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t147 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon"));
        List<String> t148 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad"));
        List<String> t149 = new ArrayList<>(List.of("Sea weeds Salad", "Coke", "Sea weeds Salad", "Coke", "Miso Ramen"));
        List<String> t150 = new ArrayList<>(List.of("Gyudon"));
        List<String> t151 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t152 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Premium Sushi Set", "Aburi Salmon", "Salmon sashimi"));
        List<String> t153 = new ArrayList<>(List.of("Salmon sashimi", "Coke", "Chocolate Cake"));
        List<String> t154 = new ArrayList<>(List.of("Miso Ramen", "Gyudon"));
        List<String> t155 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Salmon sashimi", "Aburi Salmon", "Aburi Salmon", "Salmon sashimi"));
        List<String> t156 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad", "Salmon sashimi", "Chocolate Cake", "Aburi Salmon", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t157 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Miso Ramen", "Salmon sashimi", "Coke", "Chocolate Cake"));
        List<String> t158 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t159 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon"));
        List<String> t160 = new ArrayList<>(List.of("Gyudon", "Coke", "Aburi Salmon"));
        List<String> t161 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set"));
        List<String> t162 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Miso Ramen", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t163 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t164 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t165 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t166 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon"));
        List<String> t167 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Coke", "Salmon sashimi", "Chocolate Cake", "Gyudon"));
        List<String> t168 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Coke"));
        List<String> t169 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Sea weeds Salad", "Chocolate Cake", "Coke", "Chocolate Cake"));
        List<String> t170 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Sea weeds Salad", "Coke", "Chocolate Cake"));
        List<String> t171 = new ArrayList<>(List.of("Premium Sushi Set", "Coke", "Aburi Salmon", "Salmon sashimi"));
        List<String> t172 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon", "Chocolate Cake", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t173 = new ArrayList<>(List.of("Gyudon", "Coke", "Sea weeds Salad"));
        List<String> t174 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Chocolate Cake", "Salmon sashimi", "Gyudon"));
        List<String> t175 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Aburi Salmon"));
        List<String> t176 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Aburi Salmon", "Coke", "Gyudon", "Sea weeds Salad"));
        List<String> t177 = new ArrayList<>(List.of("Coke", "Sea weeds Salad", "Gyudon", "Salmon sashimi", "Chocolate Cake", "Chocolate Cake"));
        List<String> t178 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t179 = new ArrayList<>(List.of("Coke", "Miso Ramen", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t180 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon"));
        List<String> t181 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Aburi Salmon", "Premium Sushi Set", "Sea weeds Salad"));
        List<String> t182 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t183 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t184 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Aburi Salmon", "Gyudon"));
        List<String> t185 = new ArrayList<>(List.of("Sea weeds Salad", "Coke", "Premium Sushi Set", "Gyudon"));
        List<String> t186 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t187 = new ArrayList<>(List.of("Gyudon"));
        List<String> t188 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi"));
        List<String> t189 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Coke"));
        List<String> t190 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Chocolate Cake", "Miso Ramen", "Premium Sushi Set", "Sea weeds Salad", "Coke"));
        List<String> t191 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad"));
        List<String> t192 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon"));
        List<String> t193 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Salmon sashimi", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t194 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon", "Premium Sushi Set", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t195 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Aburi Salmon", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Aburi Salmon"));
        List<String> t196 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t197 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Sea weeds Salad", "Gyudon", "Aburi Salmon"));
        List<String> t198 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t199 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Aburi Salmon"));
        List<String> t200 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Chocolate Cake", "Premium Sushi Set", "Sea weeds Salad"));
        List<String> t201 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen", "Gyudon", "Sea weeds Salad", "Coke", "Premium Sushi Set"));
        List<String> t202 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Gyudon", "Salmon sashimi"));
        List<String> t203 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t204 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen", "Chocolate Cake", "Gyudon", "Miso Ramen"));
        List<String> t205 = new ArrayList<>(List.of("Coke", "Gyudon", "Aburi Salmon", "Coke", "Salmon sashimi", "Salmon sashimi"));
        List<String> t206 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi"));
        List<String> t207 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad", "Gyudon"));
        List<String> t208 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t209 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t210 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon", "Chocolate Cake"));
        List<String> t211 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t212 = new ArrayList<>(List.of("Miso Ramen", "Gyudon", "Salmon sashimi", "Sea weeds Salad", "Miso Ramen", "Chocolate Cake", "Miso Ramen"));
        List<String> t213 = new ArrayList<>(List.of("Salmon sashimi", "Coke"));
        List<String> t214 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Salmon sashimi", "Miso Ramen", "Miso Ramen", "Salmon sashimi", "Salmon sashimi"));
        List<String> t215 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t216 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Coke", "Premium Sushi Set", "Coke", "Salmon sashimi", "Coke"));
        List<String> t217 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t218 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Aburi Salmon", "Coke", "Aburi Salmon", "Chocolate Cake"));
        List<String> t219 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Salmon sashimi"));
        List<String> t220 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set"));
        List<String> t221 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Miso Ramen"));
        List<String> t222 = new ArrayList<>(List.of("Gyudon", "Coke", "Chocolate Cake", "Chocolate Cake", "Premium Sushi Set", "Miso Ramen"));
        List<String> t223 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad", "Miso Ramen"));
        List<String> t224 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Chocolate Cake", "Sea weeds Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t225 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t226 = new ArrayList<>(List.of("Coke", "Premium Sushi Set"));
        List<String> t227 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t228 = new ArrayList<>(List.of("Gyudon", "Miso Ramen", "Premium Sushi Set"));
        List<String> t229 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Aburi Salmon", "Gyudon", "Miso Ramen"));
        List<String> t230 = new ArrayList<>(List.of("Aburi Salmon", "Aburi Salmon", "Sea weeds Salad", "Chocolate Cake", "Sea weeds Salad", "Salmon sashimi", "Aburi Salmon"));
        List<String> t231 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake"));
        List<String> t232 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad"));
        List<String> t233 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Miso Ramen", "Salmon sashimi", "Sea weeds Salad", "Sea weeds Salad", "Aburi Salmon"));
        List<String> t234 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Salmon sashimi", "Sea weeds Salad", "Salmon sashimi", "Miso Ramen"));
        List<String> t235 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Salmon sashimi", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t236 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t237 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set"));
        List<String> t238 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t239 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t240 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon"));
        List<String> t241 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t242 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon"));
        List<String> t243 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t244 = new ArrayList<>(List.of("Miso Ramen", "Gyudon", "Miso Ramen", "Premium Sushi Set"));
        List<String> t245 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t246 = new ArrayList<>(List.of("Gyudon", "Coke", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t247 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t248 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Chocolate Cake", "Sea weeds Salad", "Chocolate Cake", "Aburi Salmon"));
        List<String> t249 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Aburi Salmon", "Sea weeds Salad"));
        List<String> t250 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake"));
        List<String> t251 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Chocolate Cake"));
        List<String> t252 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Aburi Salmon", "Salmon sashimi"));
        List<String> t253 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad", "Coke", "Premium Sushi Set"));
        List<String> t254 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi"));
        List<String> t255 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Salmon sashimi", "Gyudon", "Salmon sashimi", "Miso Ramen", "Sea weeds Salad"));
        List<String> t256 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Coke", "Salmon sashimi"));
        List<String> t257 = new ArrayList<>(List.of("Aburi Salmon", "Coke", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t258 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t259 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Coke", "Coke", "Salmon sashimi", "Miso Ramen"));
        List<String> t260 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t261 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t262 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t263 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Gyudon", "Gyudon"));
        List<String> t264 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Aburi Salmon"));
        List<String> t265 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Miso Ramen", "Coke", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t266 = new ArrayList<>(List.of("Coke", "Miso Ramen", "Miso Ramen", "Salmon sashimi", "Premium Sushi Set", "Coke", "Sea weeds Salad"));
        List<String> t267 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t268 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Sea weeds Salad", "Sea weeds Salad", "Miso Ramen", "Salmon sashimi", "Coke"));
        List<String> t269 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Miso Ramen"));
        List<String> t270 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Salmon sashimi", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t271 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t272 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t273 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Gyudon"));
        List<String> t274 = new ArrayList<>(List.of("Sea weeds Salad", "Coke", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t275 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen", "Salmon sashimi", "Salmon sashimi", "Coke", "Sea weeds Salad"));
        List<String> t276 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Premium Sushi Set", "Salmon sashimi", "Miso Ramen", "Coke"));
        List<String> t277 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t278 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen", "Salmon sashimi"));
        List<String> t279 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t280 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t281 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Coke", "Sea weeds Salad"));
        List<String> t282 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t283 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen", "Gyudon", "Chocolate Cake", "Sea weeds Salad", "Salmon sashimi"));
        List<String> t284 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t285 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t286 = new ArrayList<>(List.of("Coke", "Coke", "Salmon sashimi", "Salmon sashimi", "Coke", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t287 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t288 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Gyudon", "Coke", "Coke", "Gyudon"));
        List<String> t289 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t290 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Gyudon", "Sea weeds Salad"));
        List<String> t291 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen", "Chocolate Cake", "Chocolate Cake"));
        List<String> t292 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon"));
        List<String> t293 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t294 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon", "Sea weeds Salad", "Aburi Salmon"));
        List<String> t295 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon"));
        List<String> t296 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t297 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi"));
        List<String> t298 = new ArrayList<>(List.of("Coke", "Gyudon", "Salmon sashimi", "Gyudon", "Aburi Salmon", "Salmon sashimi"));
        List<String> t299 = new ArrayList<>(List.of("Gyudon", "Coke", "Miso Ramen"));
        List<String> t300 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Premium Sushi Set"));
        List<String> t301 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Aburi Salmon"));
        List<String> t302 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Miso Ramen", "Miso Ramen"));
        List<String> t303 = new ArrayList<>(List.of("Aburi Salmon", "Gyudon"));
        List<String> t304 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Premium Sushi Set", "Coke", "Chocolate Cake"));
        List<String> t305 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Gyudon"));
        List<String> t306 = new ArrayList<>(List.of("Gyudon", "Premium Sushi Set"));
        List<String> t307 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon", "Aburi Salmon", "Coke", "Miso Ramen", "Chocolate Cake"));
        List<String> t308 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "Gyudon", "Coke"));
        List<String> t309 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Salmon sashimi"));
        List<String> t310 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t311 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Miso Ramen", "Coke"));
        List<String> t312 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Sea weeds Salad", "Miso Ramen", "Sea weeds Salad"));
        List<String> t313 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Salmon sashimi", "Miso Ramen", "Coke"));
        List<String> t314 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Coke", "Gyudon", "Miso Ramen", "Chocolate Cake"));
        List<String> t315 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon"));
        List<String> t316 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t317 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon", "Gyudon"));
        List<String> t318 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen"));
        List<String> t319 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen"));
        List<String> t320 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Miso Ramen", "Aburi Salmon"));
        List<String> t321 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Premium Sushi Set", "Salmon sashimi", "Salmon sashimi", "Miso Ramen", "Aburi Salmon"));
        List<String> t322 = new ArrayList<>(List.of("Coke"));
        List<String> t323 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t324 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon"));
        List<String> t325 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t326 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set", "Aburi Salmon"));
        List<String> t327 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi"));
        List<String> t328 = new ArrayList<>(List.of("Coke", "Aburi Salmon", "Gyudon"));
        List<String> t329 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Coke", "Premium Sushi Set"));
        List<String> t330 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Salmon sashimi", "Salmon sashimi", "Coke", "Gyudon", "Sea weeds Salad"));
        List<String> t331 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Miso Ramen"));
        List<String> t332 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t333 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Salmon sashimi", "Salmon sashimi"));
        List<String> t334 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Chocolate Cake"));
        List<String> t335 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi"));
        List<String> t336 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi", "Chocolate Cake"));
        List<String> t337 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Miso Ramen", "Aburi Salmon"));
        List<String> t338 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t339 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t340 = new ArrayList<>(List.of("Salmon sashimi", "Gyudon", "Premium Sushi Set", "Miso Ramen", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t341 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Salmon sashimi", "Premium Sushi Set", "Aburi Salmon", "Aburi Salmon", "Sea weeds Salad"));
        List<String> t342 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Salmon sashimi", "Gyudon", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t343 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Coke", "Coke", "Chocolate Cake", "Coke"));
        List<String> t344 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Premium Sushi Set", "Chocolate Cake", "Premium Sushi Set", "Coke"));
        List<String> t345 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Coke", "Aburi Salmon"));
        List<String> t346 = new ArrayList<>(List.of("Coke", "Aburi Salmon", "Miso Ramen", "Gyudon", "Aburi Salmon", "Salmon sashimi"));
        List<String> t347 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Sea weeds Salad", "Salmon sashimi", "Coke"));
        List<String> t348 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t349 = new ArrayList<>(List.of("Salmon sashimi", "Coke", "Gyudon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t350 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t351 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t352 = new ArrayList<>(List.of("Coke", "Gyudon", "Chocolate Cake", "Gyudon", "Salmon sashimi"));
        List<String> t353 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Premium Sushi Set", "Chocolate Cake", "Premium Sushi Set"));
        List<String> t354 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi"));
        List<String> t355 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Aburi Salmon", "Salmon sashimi", "Premium Sushi Set", "Miso Ramen", "Aburi Salmon"));
        List<String> t356 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Premium Sushi Set", "Gyudon", "Coke", "Coke", "Coke"));
        List<String> t357 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t358 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t359 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salmon sashimi", "Sea weeds Salad", "Coke", "Miso Ramen"));
        List<String> t360 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Chocolate Cake", "Chocolate Cake"));
        List<String> t361 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t362 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Sea weeds Salad"));
        List<String> t363 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi"));
        List<String> t364 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t365 = new ArrayList<>(List.of("Gyudon", "Miso Ramen", "Salmon sashimi", "Miso Ramen"));
        List<String> t366 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t367 = new ArrayList<>(List.of("Coke", "Coke", "Salmon sashimi", "Chocolate Cake", "Miso Ramen", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t368 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen"));
        List<String> t369 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad"));
        List<String> t370 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Gyudon", "Miso Ramen", "Miso Ramen", "Chocolate Cake", "Salmon sashimi"));
        List<String> t371 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi"));
        List<String> t372 = new ArrayList<>(List.of("Gyudon"));
        List<String> t373 = new ArrayList<>(List.of("Salmon sashimi", "Coke", "Coke"));
        List<String> t374 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Miso Ramen", "Aburi Salmon"));
        List<String> t375 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t376 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Salmon sashimi"));
        List<String> t377 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t378 = new ArrayList<>(List.of("Miso Ramen", "Gyudon"));
        List<String> t379 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t380 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Premium Sushi Set", "Premium Sushi Set", "Salmon sashimi", "Salmon sashimi"));
        List<String> t381 = new ArrayList<>(List.of("Aburi Salmon"));
        List<String> t382 = new ArrayList<>(List.of("Miso Ramen", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t383 = new ArrayList<>(List.of("Aburi Salmon", "Sea weeds Salad"));
        List<String> t384 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t385 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Salmon sashimi", "Coke"));
        List<String> t386 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t387 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t388 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t389 = new ArrayList<>(List.of("Coke"));
        List<String> t390 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Salmon sashimi", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t391 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Chocolate Cake", "Premium Sushi Set", "Coke", "Miso Ramen"));
        List<String> t392 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Sea weeds Salad", "Salmon sashimi", "Aburi Salmon", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t393 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set"));
        List<String> t394 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi"));
        List<String> t395 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t396 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t397 = new ArrayList<>(List.of("Gyudon", "Miso Ramen", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t398 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad", "Miso Ramen", "Salmon sashimi", "Salmon sashimi"));
        List<String> t399 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen", "Chocolate Cake", "Salmon sashimi", "Salmon sashimi"));
        List<String> t400 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t401 = new ArrayList<>(List.of("Aburi Salmon", "Sea weeds Salad", "Sea weeds Salad", "Miso Ramen", "Miso Ramen"));
        List<String> t402 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t403 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Miso Ramen", "Gyudon", "Salmon sashimi", "Coke", "Premium Sushi Set"));
        List<String> t404 = new ArrayList<>(List.of("Coke", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Sea weeds Salad", "Chocolate Cake", "Salmon sashimi"));
        List<String> t405 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Coke"));
        List<String> t406 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Gyudon", "Sea weeds Salad", "Salmon sashimi", "Chocolate Cake"));
        List<String> t407 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t408 = new ArrayList<>(List.of("Gyudon", "Salmon sashimi", "Sea weeds Salad", "Salmon sashimi", "Aburi Salmon", "Salmon sashimi", "Gyudon"));
        List<String> t409 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t410 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t411 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Coke", "Premium Sushi Set"));
        List<String> t412 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t413 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Coke"));
        List<String> t414 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t415 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t416 = new ArrayList<>(List.of("Coke", "Gyudon", "Aburi Salmon", "Premium Sushi Set", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t417 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Coke", "Coke", "Chocolate Cake"));
        List<String> t418 = new ArrayList<>(List.of("Premium Sushi Set", "Chocolate Cake", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t419 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t420 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Coke", "Aburi Salmon", "Miso Ramen", "Aburi Salmon"));
        List<String> t421 = new ArrayList<>(List.of("Gyudon"));
        List<String> t422 = new ArrayList<>(List.of("Aburi Salmon", "Premium Sushi Set", "Coke", "Miso Ramen", "Salmon sashimi"));
        List<String> t423 = new ArrayList<>(List.of("Coke", "Sea weeds Salad", "Gyudon", "Sea weeds Salad", "Coke", "Aburi Salmon", "Sea weeds Salad"));
        List<String> t424 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t425 = new ArrayList<>(List.of("Salmon sashimi", "Aburi Salmon", "Miso Ramen", "Chocolate Cake", "Sea weeds Salad", "Coke"));
        List<String> t426 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen"));
        List<String> t427 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Premium Sushi Set", "Chocolate Cake"));
        List<String> t428 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake", "Aburi Salmon"));
        List<String> t429 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Coke", "Coke", "Coke", "Gyudon"));
        List<String> t430 = new ArrayList<>(List.of("Gyudon"));
        List<String> t431 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t432 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Aburi Salmon", "Aburi Salmon", "Salmon sashimi", "Premium Sushi Set", "Coke"));
        List<String> t433 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Coke", "Sea weeds Salad", "Miso Ramen"));
        List<String> t434 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad", "Premium Sushi Set", "Aburi Salmon", "Salmon sashimi"));
        List<String> t435 = new ArrayList<>(List.of("Premium Sushi Set"));
        List<String> t436 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Sea weeds Salad", "Sea weeds Salad", "Miso Ramen"));
        List<String> t437 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "Salmon sashimi", "Sea weeds Salad"));
        List<String> t438 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set"));
        List<String> t439 = new ArrayList<>(List.of("Chocolate Cake", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t440 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Sea weeds Salad", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t441 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t442 = new ArrayList<>(List.of("Coke", "Salmon sashimi", "Premium Sushi Set", "Aburi Salmon", "Coke"));
        List<String> t443 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Gyudon", "Miso Ramen", "Miso Ramen", "Gyudon"));
        List<String> t444 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Chocolate Cake", "Gyudon", "Gyudon"));
        List<String> t445 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Aburi Salmon", "Salmon sashimi", "Gyudon", "Sea weeds Salad"));
        List<String> t446 = new ArrayList<>(List.of("Coke", "Miso Ramen", "Chocolate Cake", "Premium Sushi Set", "Aburi Salmon", "Aburi Salmon", "Sea weeds Salad"));
        List<String> t447 = new ArrayList<>(List.of("Premium Sushi Set", "Sea weeds Salad", "Coke", "Gyudon", "Salmon sashimi", "Coke", "Sea weeds Salad"));
        List<String> t448 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Gyudon"));
        List<String> t449 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Sea weeds Salad", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon", "Premium Sushi Set"));
        List<String> t450 = new ArrayList<>(List.of("Miso Ramen", "Gyudon", "Coke", "Coke", "Chocolate Cake"));
        List<String> t451 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Aburi Salmon", "Sea weeds Salad", "Aburi Salmon"));
        List<String> t452 = new ArrayList<>(List.of("Miso Ramen", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t453 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon", "Salmon sashimi", "Premium Sushi Set", "Premium Sushi Set", "Gyudon", "Sea weeds Salad"));
        List<String> t454 = new ArrayList<>(List.of("Coke", "Coke"));
        List<String> t455 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Gyudon", "Salmon sashimi"));
        List<String> t456 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Salmon sashimi"));
        List<String> t457 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Sea weeds Salad", "Salmon sashimi", "Premium Sushi Set"));
        List<String> t458 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi", "Gyudon", "Chocolate Cake", "Chocolate Cake"));
        List<String> t459 = new ArrayList<>(List.of("Aburi Salmon", "Salmon sashimi"));
        List<String> t460 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi", "Gyudon", "Coke", "Chocolate Cake", "Aburi Salmon", "Gyudon"));
        List<String> t461 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Sea weeds Salad", "Coke", "Gyudon", "Miso Ramen", "Miso Ramen"));
        List<String> t462 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Miso Ramen"));
        List<String> t463 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Gyudon", "Chocolate Cake", "Miso Ramen"));
        List<String> t464 = new ArrayList<>(List.of("Salmon sashimi", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t465 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Coke", "Salmon sashimi", "Premium Sushi Set", "Salmon sashimi"));
        List<String> t466 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon", "Salmon sashimi"));
        List<String> t467 = new ArrayList<>(List.of("Premium Sushi Set", "Gyudon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t468 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad", "Aburi Salmon", "Premium Sushi Set", "Aburi Salmon", "Coke", "Aburi Salmon"));
        List<String> t469 = new ArrayList<>(List.of("Aburi Salmon", "Chocolate Cake", "Salmon sashimi", "Premium Sushi Set", "Aburi Salmon", "Aburi Salmon", "Coke"));
        List<String> t470 = new ArrayList<>(List.of("Sea weeds Salad", "Salmon sashimi", "Miso Ramen", "Coke"));
        List<String> t471 = new ArrayList<>(List.of("Coke", "Premium Sushi Set", "Coke", "Aburi Salmon", "Sea weeds Salad", "Aburi Salmon"));
        List<String> t472 = new ArrayList<>(List.of("Coke", "Gyudon", "Gyudon", "Salmon sashimi", "Aburi Salmon"));
        List<String> t473 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "Salmon sashimi", "Sea weeds Salad", "Miso Ramen", "Chocolate Cake", "Miso Ramen"));
        List<String> t474 = new ArrayList<>(List.of("Coke", "Salmon sashimi", "Chocolate Cake", "Sea weeds Salad", "Aburi Salmon", "Coke", "Coke"));
        List<String> t475 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad"));
        List<String> t476 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen", "Salmon sashimi", "Coke"));
        List<String> t477 = new ArrayList<>(List.of("Sea weeds Salad", "Miso Ramen"));
        List<String> t478 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Coke", "Aburi Salmon"));
        List<String> t479 = new ArrayList<>(List.of("Sea weeds Salad", "Premium Sushi Set", "Chocolate Cake", "Salmon sashimi", "Sea weeds Salad", "Salmon sashimi"));
        List<String> t480 = new ArrayList<>(List.of("Aburi Salmon", "Miso Ramen", "Gyudon", "Premium Sushi Set", "Gyudon"));
        List<String> t481 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Aburi Salmon", "Coke", "Salmon sashimi", "Miso Ramen"));
        List<String> t482 = new ArrayList<>(List.of("Premium Sushi Set", "Salmon sashimi"));
        List<String> t483 = new ArrayList<>(List.of("Salmon sashimi", "Sea weeds Salad", "Sea weeds Salad", "Premium Sushi Set"));
        List<String> t484 = new ArrayList<>(List.of("Premium Sushi Set", "Miso Ramen"));
        List<String> t485 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Premium Sushi Set", "Sea weeds Salad"));
        List<String> t486 = new ArrayList<>(List.of("Miso Ramen", "Coke", "Sea weeds Salad"));
        List<String> t487 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Aburi Salmon"));
        List<String> t488 = new ArrayList<>(List.of("Sea weeds Salad", "Aburi Salmon"));
        List<String> t489 = new ArrayList<>(List.of("Coke", "Sea weeds Salad", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t490 = new ArrayList<>(List.of("Miso Ramen", "Salmon sashimi", "Gyudon", "Aburi Salmon", "Coke", "Miso Ramen", "Premium Sushi Set"));
        List<String> t491 = new ArrayList<>(List.of("Premium Sushi Set", "Aburi Salmon", "Premium Sushi Set", "Gyudon"));
        List<String> t492 = new ArrayList<>(List.of("Salmon sashimi", "Miso Ramen", "Sea weeds Salad", "Sea weeds Salad", "Premium Sushi Set", "Premium Sushi Set"));
        List<String> t493 = new ArrayList<>(List.of("Miso Ramen", "Aburi Salmon"));
        List<String> t494 = new ArrayList<>(List.of("Coke", "Coke", "Miso Ramen", "Premium Sushi Set"));
        List<String> t495 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Gyudon", "Aburi Salmon", "Coke", "Sea weeds Salad", "Aburi Salmon"));
        List<String> t496 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t497 = new ArrayList<>(List.of("Gyudon"));
        List<String> t498 = new ArrayList<>(List.of("Premium Sushi Set", "Premium Sushi Set"));
        List<String> t499 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Chocolate Cake", "Miso Ramen", "Aburi Salmon"));
        List<String> t500 = new ArrayList<>(List.of("Gyudon", "Aburi Salmon", "Coke", "Chocolate Cake", "Salmon sashimi", "Gyudon", "Gyudon"));

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
