# Description

This library is extension for awesome libGDX library - https://github.com/libgdx/libgdx

Purpose of this library is to simplify to create 2d games using Stage2d package. Library contains only 2 classes and very easy to use.

# How to use it in your project?

This library is available via JitPack. See more - https://jitpack.io

Edit your top build.gradle file:

**Add JitPack repository**

    allprojects {
        ...
        repositories {
            ...
	          maven { url "https://jitpack.io" }
        }
    }
    
**Add Android dependency:**

    project(":android") {
        ...
        dependencies {
           ...
           compile 'com.github.1nt3g3r:gdx-screen2d-manager:1.0.1'
        }
    }

**Add Core dependency:**

    project(":core") {
        ...
        dependencies {
              ...
    	        compile 'com.github.1nt3g3r:gdx-screen2d-manager:1.0.1'
        }
    }
    
 You see we are using **1.0.1** version here. But you can change it. Just look **Releases** section of this repository if you want to use any other version.
  
 Refresh your gradle dependencies using **./gradlew --refresh-dependencies**. Call it from command line.

# How to init it?

Your ApplicationListener should be subclass of Game. And you should have SpriteBatch instance. After it you can create ScreenManager instance. Example:

    public class MyGame extends Game {
        ...
        private SpriteBatch batch;
        private ScreenManager screenManager
        ...
        
        public void create() {
           ...
           batch = new SpriteBatch();
           screenManager = new ScreenManager(this, batch); //Pass Game instance and SpriteBatch instance
           ...
        }
        
        public ScreenManager getScreenManager() { //Optional step, just provide method to access this ScreenManager instance
           return screenManager;
        }
    }
    
# How to create my own screen?

Each custom screen shoud extends from AbstractScreen and should have empty constructor. You should initialize your screen in init() method, not in constructor. Example:

    public class MyScreen extends AbstractScreen {
        // We don't create any constructors
        
        public void init() { // Setup screen
            Actor testActor = new Actor();
            testActor.setSize(100, 100);
            testActor.debug();
            addActor(testActor);
        }
    }
    
When you have your screen, you can show it by calling screenManager.showScreen(MyScreen.class). It will create instance of your screen and will set it as current screen.

# What about if I have already some screen which not extends AbstractScreen. Can I use it?

Yes, you can. Just call screenManager.showScreen(yourScreenInstance). Example:

    public class MyExistingScreen implements Screen {
        ...
    }
    
    ...
    public void create() {
       ...
       screenManager.setScreen(new MyExistingScreen());
       ...
    }

# Reload screen
Sometimes you need to dispose and create current screen. For example, you changed language settings, so you need update all text labels according to new language. Easisest way (as for me) - just reload current screen. You can do it by calling screenManager.reload()

# More cool things in AbstractScreen

Example below show you some advanced features that speed up development
    
    public class TestScreen extends AbstractScreen {
        @Override
        public void onBackPressed() { // Override this method to catch when user press Back or Escape key
            System.out.println("Back or Escape pressed!");
        }
        
        @Override
        public void init() {
            postTask(1f, new Runnable() ...}; // You can execute any task with given delay (1 seconds in this example)
            repeatTask(5f, new Runnable() ...}; // You can infinitely repeat task with given delay (5 seconds in this example)
            
            debugKey(Input.Keys.T, new Runnable() { // For debug purposes you can program some actions to some keys
               public void run() {
                    System.out.println("T key was pressed!");
               }
            });
        }
    }
    
# What more?
Don't hesitate me for any issues and possible improvements. I will be glad to fix it.
