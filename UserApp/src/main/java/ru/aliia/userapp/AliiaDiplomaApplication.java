package ru.aliia.userapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AliiaDiplomaApplication {

    public static final String JSON_1 =
            "{\n" +
                    "  \"message\": [\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      30,\n" +
                    "      20,\n" +
                    "      104,\n" +
                    "      112\n" +
                    "    ],\n" +
                    "    \"label\": \"label\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      16,\n" +
                    "      951,\n" +
                    "      68,\n" +
                    "      1003\n" +
                    "    ],\n" +
                    "    \"label\": \"floating_action_button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      144,\n" +
                    "      20,\n" +
                    "      507,\n" +
                    "      250\n" +
                    "    ],\n" +
                    "    \"label\": \"menu\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      140,\n" +
                    "      365,\n" +
                    "      600,\n" +
                    "      679\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      140,\n" +
                    "      705,\n" +
                    "      296,\n" +
                    "      868\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      320,\n" +
                    "      711,\n" +
                    "      453,\n" +
                    "      868\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      492,\n" +
                    "      719,\n" +
                    "      580,\n" +
                    "      877\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      150,\n" +
                    "      890,\n" +
                    "      220,\n" +
                    "      950\n" +
                    "    ],\n" +
                    "    \"label\": \"floating_action_button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      227,\n" +
                    "      890,\n" +
                    "      287,\n" +
                    "      950\n" +
                    "    ],\n" +
                    "    \"label\": \"floating_action_button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      628,\n" +
                    "      448,\n" +
                    "      690,\n" +
                    "      584\n" +
                    "    ],\n" +
                    "    \"label\": \"button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      605,\n" +
                    "      776,\n" +
                    "      633,\n" +
                    "      810\n" +
                    "    ],\n" +
                    "    \"label\": \"floating_action_button\"\n" +
                    "  }\n" +
                    "]\n" +
                    "}\n";

    public static final String JSON_2 =
            "{ \"message\":\n" +
                    "[\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      30,\n" +
                    "      20,\n" +
                    "      104,\n" +
                    "      112\n" +
                    "    ],\n" +
                    "    \"label\": \"label\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      14,\n" +
                    "      840,\n" +
                    "      68,\n" +
                    "      1000\n" +
                    "    ],\n" +
                    "    \"label\": \"label\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      87,\n" +
                    "      23,\n" +
                    "      212,\n" +
                    "      178\n" +
                    "    ],\n" +
                    "    \"label\": \"menu\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      157,\n" +
                    "      203,\n" +
                    "      619,\n" +
                    "      810\n" +
                    "    ],\n" +
                    "    \"label\": \"data_table\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      658,\n" +
                    "      409,\n" +
                    "      712,\n" +
                    "      644\n" +
                    "    ],\n" +
                    "    \"label\": \"button\"\n" +
                    "  }\n" +
                    "]\n" +
                    "}";

    public static final String JSON_3 =
            "{\"message\" :[ \n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      20,\n" +
                    "      14,\n" +
                    "      75,\n" +
                    "      172\n" +
                    "    ],\n" +
                    "    \"label\": \"label\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      21,\n" +
                    "      853,\n" +
                    "      94,\n" +
                    "      1000\n" +
                    "    ],\n" +
                    "    \"label\": \"button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      98,\n" +
                    "      247,\n" +
                    "      222,\n" +
                    "      407\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      75,\n" +
                    "      436,\n" +
                    "      572,\n" +
                    "      620\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      83,\n" +
                    "      639,\n" +
                    "      215,\n" +
                    "      772\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      270,\n" +
                    "      264,\n" +
                    "      404,\n" +
                    "      415\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      270,\n" +
                    "      644,\n" +
                    "      399,\n" +
                    "      767\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      449,\n" +
                    "      281,\n" +
                    "      570,\n" +
                    "      422\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      454,\n" +
                    "      652,\n" +
                    "      574,\n" +
                    "      772\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      651,\n" +
                    "      299,\n" +
                    "      698,\n" +
                    "      517\n" +
                    "    ],\n" +
                    "    \"label\": \"button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      635,\n" +
                    "      567,\n" +
                    "      699,\n" +
                    "      744\n" +
                    "    ],\n" +
                    "    \"label\": \"button\"\n" +
                    "  }\n" +
                    "]\n" +
                    "}";

    public static final String JSON_4 =
            "{\"message\":[ \n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      20,\n" +
                    "      20,\n" +
                    "      60,\n" +
                    "      60\n" +
                    "    ],\n" +
                    "    \"label\": \"floating_action_button\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      30,\n" +
                    "      80,\n" +
                    "      104,\n" +
                    "      112\n" +
                    "    ],\n" +
                    "    \"label\": \"label\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      94,\n" +
                    "      54,\n" +
                    "      279,\n" +
                    "      835\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      368,\n" +
                    "      20,\n" +
                    "      560,\n" +
                    "      250\n" +
                    "    ],\n" +
                    "    \"label\": \"menu\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      368,\n" +
                    "      311,\n" +
                    "      453,\n" +
                    "      472\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      368,\n" +
                    "      492,\n" +
                    "      453,\n" +
                    "      653\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      368,\n" +
                    "      673,\n" +
                    "      453,\n" +
                    "      835\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      475,\n" +
                    "      311,\n" +
                    "      560,\n" +
                    "      472\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      475,\n" +
                    "      492,\n" +
                    "      560,\n" +
                    "      653\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"positions\": [\n" +
                    "      475,\n" +
                    "      673,\n" +
                    "      560,\n" +
                    "      835\n" +
                    "    ],\n" +
                    "    \"label\": \"image\"\n" +
                    "  }\n" +
                    "]\n" +
                    "}\n";

    public static String fakeProcess(String fileName) {
        switch (fileName) {
            case "1.PNG":
                return JSON_1;
            case "2.PNG":
                return JSON_2;
            case "3.PNG":
                return JSON_3;
            case "4.PNG":
                return JSON_4;
            default:
                return "";
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(AliiaDiplomaApplication.class, args);
    }

}
