# osbuddy-community [![Discord](https://img.shields.io/discord/177282798799945729.svg)](https://discord.gg/osbuddy)
The OSBuddy Community API enables free, open source plugin development for OldSchool RuneScape.

Plugins merged into this repository will be made freely available for install via the Community tab of the OSBuddy client.

## Building a plugin
Your plugins must be built against the latest API, which can be built from source via the /api directory in this repository, or obtained from the [GitHub releases](https://github.com/RSBuddy/osbuddy-community/releases).
An example plugin is provided which shows other typical dependencies, which are managed using gradle. We suggest using IntelliJ IDEA to import the gradle project.

## Creating a plugin
Make sure you have run OSBuddy so that you have an OSBuddy folder in your user directory. This will contain loader.jar, which you will need to your plugin project's class path so that you can run your plugin.

On Linux or macOS run this command to download it. ```curl -L --create-dirs -o ~/OSBuddy/loader.jar http://cdn.rsbuddy.com/live/f/loader/OSBuddy.jar```

To run your plugin (we recommend launching in Debug mode), launch the main class com.osbuddy.loader.Loader with the following VM arguments:
```
-Dplugin-classpath=$PROJECT_DIR$/plugins/example/out/production/classes
-Dplugin-resources=$PROJECT_DIR$/plugins/example/out/production/resources
-Dnofork=true
-Ddev=true
-Dlog.level=all
-Xmx512m
```

Loader.xml has the above configuration for Intellij. Copy it to the .idea/runConfigurations/ folder and restart Intellij.
```
mkdir .idea/runConfigurations/
cp Loader.xml .idea/runConfigurations/
```


Select use classpath of module: com.rsbuddy.osrs.example.main

Your -Dplugin-classpath and -Dplugin-resources directories may differ depending on how you are building your code.

## Contributions
We will accept merge requests for contributions that match the permissive [LICENSE](https://github.com/rsbuddy/osbuddy-community/LICENSE) used in this repository. Further guidelines that will be made available here shortly.
