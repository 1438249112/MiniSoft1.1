package Test;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.sun.phobos.script.javascript.RhinoScriptEngine;
import com.sun.phobos.script.javascript.RhinoScriptEngineFactory;
import com.sun.script.groovy.GroovyScriptEngineFactory;
import com.sun.script.jruby.JRubyScriptEngineFactory;
import com.sun.script.jython.JythonScriptEngineFactory;

public class Snippet {
	public static void main(String[] args) {
//		  ScriptEngineManager manager = new ScriptEngineManager();
//	       
//		    manager.registerEngineExtension("js", new RhinoScriptEngineFactory());
//	        manager.registerEngineExtension("groovy", new GroovyScriptEngineFactory());
//	        manager.registerEngineExtension("rb", new JRubyScriptEngineFactory());
//	        manager.registerEngineExtension("jsEngine", new RhinoScriptEngineFactory());
//	        manager.registerEngineExtension("py", new JythonScriptEngineFactory());
//	        ScriptEngine  jsEngine = manager.getEngineByExtension("jsEngine");
		 try
	        { 
			 RhinoScriptEngine ret = new RhinoScriptEngine();

	           Object jsonObject = ret.eval(new FileReader("C:/Users/litsoft/Desktop/test/input1.json"));
	        }
	        catch(Exception e)
	        {
	        	 System.out.println(e.getLocalizedMessage().toString());
	        }
	}
	
  
	 
}

