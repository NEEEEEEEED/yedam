// import * as md from "./module.js";
// md.module("test");
// md.area(10, 20);

import { module as mod, area } from "./module.js";
import sq, { circle } from "./module1.js";
mod("test");
area(10, 20);
sq();
circle();
