/*******************************************************************************************************
 *
 * MessageData.java, in gaml.extension.fipa, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.fipa;

import gama.core.metamodel.agent.IAgent;
import gama.core.util.IList;

/**
 * The Message class represents the piece of information transfered between agents capable of communicating.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class MessageData {

	/** The name of sender. */
	private IAgent sender;

	/** The name of all receivers. */
	private IList<IAgent> receivers;

	/** The content of the message. */
	private IList content;

	/** The performative of the message (defined by the FIPA). */
	private Performative performative;

	/** The associated conversation. */
	private Conversation conversation;

	/**
	 * Gets the name of sender.
	 *
	 * @return the name of sender
	 */
	public IAgent getSender() { return sender; }

	/**
	 * Sets the name of sender.
	 *
	 * @param sender
	 *            the new name of sender
	 */
	public void setSender(final IAgent sender) { this.sender = sender; }

	/**
	 * Gets the name of all receivers.
	 *
	 * @return the name of all receivers
	 */
	public IList getReceivers() { return receivers; }

	/**
	 * Sets the name of all receivers.
	 *
	 * @param receivers
	 *            the new name of all receivers
	 */
	public void setReceivers(final IList receivers) { this.receivers = receivers; }

	/**
	 * Gets the content of the message.
	 *
	 * @return the content of the message
	 */
	public IList getContent() { return content; }

	/**
	 * Sets the content of the message.
	 *
	 * @param content
	 *            the new content of the message
	 */
	public void setContent(final IList content) {
		if (content != null) { this.content = content; }
	}

	/**
	 * Gets the performative name.
	 *
	 * @return the performative name
	 */
	public String getPerformativeName() { return performative.name(); }

	/**
	 * Gets the performative of the message (defined by the FIPA).
	 *
	 * @return the performative of the message (defined by the FIPA)
	 */
	public Performative getPerformative() { return performative; }

	/**
	 * Sets the performative name.
	 *
	 * @param performative
	 *            the new performative name
	 */
	public void setPerformativeName(final String performative) {
		this.performative = Performative.valueOf(performative);
	}

	/**
	 * Sets the performative of the message (defined by the FIPA).
	 *
	 * @param performative
	 *            the new performative of the message (defined by the FIPA)
	 */
		/*
		 * (non-Javadoc)
		 *
		 * @see gaml.extensions.fipa.IMessage#setPerformative(int)
		 */
	public void setPerformative(final Performative performative) { this.performative = performative; }

	/**
	 * Gets the associated conversation.
	 *
	 * @return the associated conversation
	 */
	public Conversation getConversation() { return conversation; }

	/**
	 * Sets the associated conversation.
	 *
	 * @param conv
	 *            the new associated conversation
	 */
	public void setConversation(final Conversation conv) { conversation = conv; }

	@Override
	public String toString() {
		final StringBuilder retVal = new StringBuilder();
		retVal.append("Message[sender : " + sender + ", receivers : " + receivers + ", conversation : " + conversation
				+ ", performative : " + performative + "]");
		return retVal.toString();
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public MessageData getMessage() { return this; }

}
