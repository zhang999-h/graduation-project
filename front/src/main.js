import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import '@kangc/v-md-editor/lib/style/preview.css';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';



import Prism from 'prismjs';

VueMarkdownEditor.use(vuepressTheme, {
    Prism,
});

// highlightjs
import hljs from 'highlight.js';

VMdPreview.use(githubTheme, {
    Hljs: hljs,
});

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as EleIcons from '@element-plus/icons-vue'

import 'prismjs/components/prism-json';

const app = createApp(App)
app.use(store).use(router).use(VueMarkdownEditor).use(ElementPlus).use(VMdPreview).mount('#app')
for(let name in EleIcons){
    app.component(name,EleIcons[name])
}


