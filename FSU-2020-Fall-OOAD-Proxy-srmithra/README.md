# FSU-2020-Fall-OOAD-Proxy

Run the ShowFileContents class, you should get an usage message
Usage: java ShowFileContents <directory>

You need to run ShowFileContents with data as a program parameter.
To do this in Eclipse, click on the little down arrow next to the
big green 'run' icon. This will give you a menu. Select
'Run Configurations...'

There you'll see the run configuration dialog. Click on the
'Arguments' tab and you should see a string box with the label
'Program Arguments'. Just type in 'data' (without the quotes)
and now you will run with the correct directory.

You should get 

	File: data/cree.txt
	"When all the trees have been cut down, when all the animals have been hunted,
	 when all the waters are polluted, when all the air is unsafe to breathe, only
	 then will you discover you cannot eat money."
	- Cree Prophecy
	
	File: data/maewest.txt
	"You only live once, but if you do it right, once is enough."
	- Mae West
	
	File: data/rumi.txt
	"If you are irritated by every rub, how will your mirror be polished?"
	- Jalaluddin Mevlana Rumi
	
	File: data/anaisnin.txt
	"There came a time when the risk to remain tight in the bud was more painful
	 than the risk it took to blossom."
	- Anais Nin
	
	File: data/marktwain.txt
	"Whenever you find yourself on the side of the majority, it is time to pause and
	 reflect."
	- Mark Twain
	
But notice that it takes a while for each thing to print. What we want to is create
a proxy file stringifier called FileStringifierProxy. This is going take the place
of SlowFileStringifier in ShowFileContents.

To do this, copy the SlowFileStringifier to FileStringifierProxy. You will now need
to make this implement Runnable. This is going to be a subject. You can do this
one of two ways
1. Use the deprecated Observer/Observable classes in java.util
2. Use the PropertyChangeListener, PropertyChangeSupport, PropertyChangeEvent in java.beans

To make ShowFileContents a listener you'll need to have it implement PropertyChangeListener
and add the needed method propertyChange() and make it accept the Stringifier and 
have it call ShowFileContents.printFileContents(). You should make printFileContents()
synchronized or your get odd output.

So, back to FileStringifierProxy. When you call the constructor, it should create a
SlowFileStringifier internally and save it and an outputString which is null. If you
are using the property change classes you'll also need to add a new PropertyChangeSupport,
call it propertySubject.

Add the addObserver() method and if you are using the property change listeners have it
accept a PropertyChangeListener object and then call
propertySubject.addPropertyChangeListener("fileContents", listener)
where listener is at some point going to be the ShowFileContents.

Since FileStringifierProxy is runnable, you'll need to add a run() method. This method
should call the SlowFileStringifier.stringify() and set outputString to the return value.
Then fire off an event: using update() if you are using Observer/Observable, and
propertySubject.firePropertyChange("fileContents", null, this) if you are using the
java bean classes.

You'll need to change the FileStringifierProxy.stringify method to check outputString. If
it is null then start a thread and run 'this', then return
"Reading "+this.getFilePath()
If outputString is not null, then return outputString.

Running 'this' in a thread will run the SlowFileStringifier.stringify and set the
outputString.

Now a few more changes in ShowFileContents. You've added the update() or propertyChange()
already, but you need to tell ShowFileContents to use the new proxy class. To do this
you'll need to create a new factory called FileStringifierProxyFactory. You'll want to
have a constructor that accepts and saves a PropertyChangeListener. The
	public FileStringifier createStringifier(String filename)
will create a new FileStringifierProxyFactory and call the addObserver with the
listener.

Then in ShowFileContents change the line
	StringifierFactory factory = new SlowFileStringifierFactory();
use StringifierFactory factory = new FileStringifierProxyFactory(fileContents);
instead.

 


Now, you should be able to run the ShowFileContents class and get something like the
following. You should notice that this runs faster too.

	File: data/cree.txt
	Reading data/cree.txt
	
	File: data/maewest.txt
	Reading data/maewest.txt
	
	File: data/rumi.txt
	Reading data/rumi.txt
	
	File: data/anaisnin.txt
	Reading data/anaisnin.txt
	
	File: data/marktwain.txt
	Reading data/marktwain.txt
	
	File: data/cree.txt
	"When all the trees have been cut down, when all the animals have been hunted,
	 when all the waters are polluted, when all the air is unsafe to breathe, only
	 then will you discover you cannot eat money."
	- Cree Prophecy
	
	File: data/anaisnin.txt
	"There came a time when the risk to remain tight in the bud was more painful
	 than the risk it took to blossom."
	- Anais Nin
	
	File: data/maewest.txt
	"You only live once, but if you do it right, once is enough."
	- Mae West
	
	File: data/marktwain.txt
	"Whenever you find yourself on the side of the majority, it is time to pause and
	 reflect."
	- Mark Twain
	
	File: data/rumi.txt
	"If you are irritated by every rub, how will your mirror be polished?"
	- Jalaluddin Mevlana Rumi

When you get done, you should have two new classes: FileStringifierProxy and
FileStringifierProxyFactory. You would have to make changes to ShowFileContent.
You shouldn't have to change anything else.